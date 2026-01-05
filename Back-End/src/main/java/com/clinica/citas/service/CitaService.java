package com.clinica.citas.service;

import com.clinica.citas.dto.CitaDTO;
import com.clinica.citas.mapper.CitaMapper;
import com.clinica.citas.model.Cita;
import com.clinica.citas.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService {

    private final CitaRepository repo;
    private final CitaMapper mapper;

    public CitaService(CitaRepository citaRepository, CitaMapper citaMapper) {
        this.repo = citaRepository;
        this.mapper = citaMapper;
    }

    public CitaDTO save(CitaDTO dto){

        //Validaciones
        //Validacion de dni
        if(dto.getDni() == null){
            throw new IllegalArgumentException("El dni no puede ser nulo");
        }

        //Convierto el dni a mayusculas y le quito los espacios
        String dni = dto.getDni().toUpperCase().trim();
        dto.setDni(dni);

        //Validacion de dni, debe tener 8 numeros y una letra
        if(dto.getDni().length() != 9){
            throw new IllegalArgumentException("El DNI tiene que contener 8 numeros y una letra");
        }

        //Validacion de dni, debe tener solo numeros
        for(int i = 0; i < 8; i++){
            if(!Character.isDigit(dto.getDni().charAt(i))){
                throw new IllegalArgumentException("El DNI tiene que contener 8 numeros y una letra");
            }
        }

        //Validacion de dni, debe tener una letra
        if(!Character.isLetter(dto.getDni().charAt(8))){
            throw new IllegalArgumentException("El DNI tiene que contener 8 numeros y una letra");
        }

        if(repo.existsByFechaAndHora(dto.getFecha(), dto.getHora())){
            throw new IllegalArgumentException("Ya existe una cita para esa fecha y hora");
        }

        Cita cita = mapper.citaDTOToCita(dto);
        cita = repo.save(cita);
        return mapper.citaToCitaDTO(cita);
    }

    public List<CitaDTO> findAll(){
        return repo.findAll().stream().map(mapper::citaToCitaDTO).collect(Collectors.toList());
    }

    public List<CitaDTO> getFecha(String fecha){
        return repo.findByFecha(fecha).stream().map(mapper::citaToCitaDTO).collect(Collectors.toList());
    }

    public CitaDTO update(Long id, CitaDTO dto) {

        Cita existente = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La cita no existe"));

        if (repo.existsByFechaAndHora(dto.getFecha(), dto.getHora())
                && !(existente.getFecha().equals(dto.getFecha())
                && existente.getHora().equals(dto.getHora()))) {
            throw new IllegalArgumentException("Ya existe una cita para esa fecha y hora");
        }

        existente.setFecha(dto.getFecha());
        existente.setHora(dto.getHora());
        existente.setNombreCliente(dto.getNombreCliente());
        existente.setDni(dto.getDni());
        existente.setNombreMascota(dto.getNombreMascota());

        Cita guardada = repo.save(existente);
        return mapper.citaToCitaDTO(guardada);
    }

    public void delete(Long id) {

        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("La cita no existe");
        }

        repo.deleteById(id);
    }


}
