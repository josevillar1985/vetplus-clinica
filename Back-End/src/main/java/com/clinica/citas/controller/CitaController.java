package com.clinica.citas.controller;

import com.clinica.citas.dto.CitaDTO;
import com.clinica.citas.service.CitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
@CrossOrigin
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    @GetMapping
    public List<CitaDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/fecha")
    public List<CitaDTO> getFecha(@RequestParam String fecha){
        return service.getFecha(fecha);
    }

    @PostMapping
    public CitaDTO save(@RequestBody CitaDTO dto){
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public CitaDTO update(@PathVariable Long id, @RequestBody CitaDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
