package org.benigaslo.controller;

public class ModificacionDTO  {
    String eliminar, nuevoNombre, nuevonumTlf;

    public ModificacionDTO(String eliminar, String nuevoNombre, String nuevonumtlf) {
        this.eliminar = eliminar;
        this.nuevoNombre = nuevoNombre;
        this.nuevonumTlf = nuevonumtlf;
    }
}
