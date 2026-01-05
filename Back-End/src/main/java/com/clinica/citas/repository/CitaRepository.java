package com.clinica.citas.repository;

import com.clinica.citas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    //Metodos personalizados
     List<Cita> findByFecha(String fecha);

    boolean existsByFechaAndHora(String fecha, String hora);
}
