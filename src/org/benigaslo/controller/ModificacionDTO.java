package org.benigaslo.controller;

import org.benigaslo.model.Agenda;

import java.util.List;

public class ModificacionDTO  {
    public String nombreOriginal, nuevoNombre, nuevonumTlf;

    public ModificacionDTO(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }


    public ModificacionDTO(String nombreOriginal ,String nuevoNombre, String nuevonumtlf) {
        this.nombreOriginal=nombreOriginal;
        this.nuevoNombre = nuevoNombre;
        this.nuevonumTlf = nuevonumtlf;
    }
}
