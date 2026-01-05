package com.clinica.citas.dto;

public class CitaDTO {

    private Long id;
    private String fecha;
    private String hora;
    private String nombreCliente;
    private String dni;
    private String nombreMascota;

    public CitaDTO() {
    }

    public CitaDTO(Long id, String fecha, String hora, String nombreCliente, String dni, String nombreMascota) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.nombreMascota = nombreMascota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
}
