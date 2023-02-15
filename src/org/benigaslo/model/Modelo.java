package org.benigaslo.model;

import org.benigaslo.controller.AgendaDTO;
import org.benigaslo.controller.ModificacionDTO;
import org.benigaslo.controller.NuevoContactoDTO;

import java.util.ArrayList;
import java.util.List;

public class Modelo {

    public List<Agenda> agendas = new ArrayList<>();


    public void guardarAgenda(AgendaDTO datos) {
        agendas.add(new Agenda(datos.nombre, datos.descrpcion));
    }


    public List<Agenda> obtenerListaAgendas() {
        return agendas;
    }

    public void eliminarContacto(int numeroAgenda, String nomContactoAEliminar) {


        agendas.get(numeroAgenda).contactos.removeIf(contacto -> contacto.nombre.equals(nomContactoAEliminar));


    }

    public void eliminarAgenda(String nom) {
        agendas.removeIf(agenda -> agenda.nombre.equals(nom));

    }

    public void guardaEsteContacto(NuevoContactoDTO datos) {

        Contacto contacto = new Contacto(datos.nombre, datos.telefono);

        // String numerosAgenda = "1 7 13 23 34";
        //                              |
        //                              |
        //                           split(" ")
        //                              |
        //                              |
        //                              v
        //                  ["1", "7", "13", "23", "34"]

        for (String numero : datos.numerosAgenda.split(" ")) {
            agendas.get(Integer.parseInt(numero)).contactos.add(contacto);
        }


    }

    public Agenda obtenerAgendaSegunSuNumero(int quinaAgendaVolVore) {

        return agendas.get(quinaAgendaVolVore);


    }

    public List<Contacto> buscarContactos(String busqueda) {
        List<Contacto> contactosEncontrados = new ArrayList<>();
        for (Agenda agenda : agendas) {
            for (Contacto contacto : agenda.contactos)
                if (contacto.nombre.contains(busqueda) || contacto.telefono.contains(busqueda)) {
                    contactosEncontrados.add(contacto);
                }
        }
        return contactosEncontrados;
    }

    public boolean comprobarsiNomesta(ModificacionDTO datos){
        for (Agenda agenda : agendas) {
            for (Contacto contacto : agenda.contactos) {
                if (datos.nombreOriginal.equals(contacto.nombre)) {
                    return true;
                }
            }

        }
        return false;
    }

    public void modificaContacto(ModificacionDTO datos) {

        estedaci:
        for (Agenda agenda : agendas) {
            for (Contacto contacto : agenda.contactos) {
                if (datos.nombreOriginal.equals(contacto.nombre)) {
                    contacto.nombre = datos.nuevoNombre;
                    contacto.telefono = datos.nuevonumTlf;
                }
            }

        }


    }
}


