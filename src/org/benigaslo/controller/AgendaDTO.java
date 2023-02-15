package org.benigaslo.controller;

public class AgendaDTO {
    public String nombre;
    public String descrpcion;

    public AgendaDTO(String nombre, String ciudad) {
        this.nombre = nombre;
        this.descrpcion = ciudad;
    }

}
