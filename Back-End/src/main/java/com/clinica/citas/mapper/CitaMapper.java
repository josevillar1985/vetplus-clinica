package com.clinica.citas.mapper;

import com.clinica.citas.dto.CitaDTO;
import com.clinica.citas.model.Cita;
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {

    public CitaDTO citaToCitaDTO(Cita cita) {
        CitaDTO dto = new CitaDTO();
        dto.setId(cita.getId());
        dto.setFecha(cita.getFecha());
        dto.setHora(cita.getHora());
        dto.setNombreCliente(cita.getNombreCliente());
        dto.setDni(cita.getDni());
        dto.setNombreMascota(cita.getNombreMascota());
        return dto;
    }

    public Cita citaDTOToCita(CitaDTO dto){
        Cita cita = new Cita();
        cita.setId(dto.getId());
        cita.setFecha(dto.getFecha());
        cita.setHora(dto.getHora());
        cita.setNombreCliente(dto.getNombreCliente());
        cita.setDni(dto.getDni());
        cita.setNombreMascota(dto.getNombreMascota());
        return cita;
    }
}
