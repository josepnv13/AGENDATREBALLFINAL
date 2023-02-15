package org.benigaslo.controller;

import org.benigaslo.model.Agenda;
import org.benigaslo.model.Contacto;
import org.benigaslo.model.Modelo;
import org.benigaslo.view.Vista;

import java.util.InputMismatchException;
import java.util.List;

public class Controlador {

    public Vista vista = new Vista();
    public Modelo modelo = new Modelo();


    public void aCorrer() {


        while (true) {
            try {
                vista.mostrarMenu();

                int o = vista.pedirOpcion();

                if (o == 1) {
                    List<Agenda> lalistaquemeretorna = modelo.obtenerListaAgendas();

                    NuevoContactoDTO datosNuevoContacto = vista.muestraPantallaAnyadirContacto(lalistaquemeretorna);


                    modelo.guardaEsteContacto(datosNuevoContacto);
                }
                else if (o == 3) {
                    List<Agenda> agendas = modelo.obtenerListaAgendas();
                    int quinaAgendaVolVore = vista.pedirQueAgendaQuiereVer(agendas);
                    Agenda agenda = modelo.obtenerAgendaSegunSuNumero(quinaAgendaVolVore);
                    vista.mostrarAgenda(agenda);

                }
                else if (o == 4) {
                    AgendaDTO datos = vista.pedirDatosAgendaNueva();
                    modelo.guardarAgenda(datos);
                    // crear nueva agenda


                }
                else if (o == 5) {
                    System.out.println("Ustd tiene estas agendas: ");
                    List<Agenda> agendas = modelo.obtenerListaAgendas();
                    vista.voreLlistaAgendes(agendas);


                }
                else if (o == 2) {
                    //eliminar contacte
                    List<Agenda> agendas = modelo.obtenerListaAgendas();
                    int quinaAgendaVolVore = vista.pedirQueAgendaQuiereVer(agendas);

                    Agenda agenda = modelo.obtenerAgendaSegunSuNumero(quinaAgendaVolVore);
                    vista.mostrarAgenda(agenda);


                    String nom = vista.pedirContactoeliminar();
                    modelo.eliminarContacto(quinaAgendaVolVore, nom);


                }
                else if (o == 6) {
                    List<Agenda> agendas = modelo.obtenerListaAgendas();
                    vista.voreLlistaAgendes(agendas);
                    String nomEliminar = vista.pedirAgendaAEliminar();
                    modelo.eliminarAgenda(nomEliminar);

                }
                else if (o == 7) {

                    ModificacionDTO datos = vista.pedirDatosModificacion();
                    boolean error = modelo.comprobarsiNomesta(datos);
                    if (error==false) {
                        vista.imprimirNoExiste();
                    } else {
                        ModificacionDTO datos1 = vista.pedirDatosqueQuedan();
                        modelo.modificaContacto(datos1);
                    }

                }
                else if (o == 8) {
                    String busqueda = vista.buscarContacto();
                    List<Contacto> contactosEncontrados = modelo.buscarContactos(busqueda);
                    vista.imprimirContactosEncontrados(contactosEncontrados);
                }
                else if (o == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                vista.nextLine();
                System.out.println("?????????¿¿¿¿¿¿¿");
                System.out.println("Not a correct option! Try again");
            }
        }


    }

}


