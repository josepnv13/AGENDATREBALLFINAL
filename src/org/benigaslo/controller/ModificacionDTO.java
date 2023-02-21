package org.benigaslo.controller;

import org.benigaslo.model.Agenda;

import java.util.List;

public class ModificacionDTO  {
    public String nombreOriginal, nuevoNombre, nuevonumTlf;

    public ModificacionDTO(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }


    public ModificacionDTO(String nuevoNombre, String nuevonumtlf) {
        this.nuevoNombre = nuevoNombre;
        this.nuevonumTlf = nuevonumtlf;
    }

}
