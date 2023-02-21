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

                    if (lalistaquemeretorna.size() == 0){
                        vista.muestraErrorNoAgendas();
                    } else {
                        NuevoContactoDTO datosNuevoContacto = vista.muestraPantallaAnyadirContacto(lalistaquemeretorna);
                        modelo.guardaEsteContacto(datosNuevoContacto);
                    }
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
                    List<Agenda> agendas = modelo.obtenerListaAgendas();
                    int quinaAgendaVolVore = vista.pedirQueAgendaQuiereVer(agendas);

                    Agenda agenda = modelo.obtenerAgendaSegunSuNumero(quinaAgendaVolVore);

                    vista.mostrarAgenda(agenda);

                    ModificacionDTO datos = vista.pedirDatosModificacion();

                    boolean error = modelo.comprobarsiNomesta(datos);

                    if (!error) {
                        vista.imprimirNoExiste();
                    } else {
                        ModificacionDTO nuevosDatos = vista.pedirDatosqueQuedan();
                        nuevosDatos.nombreOriginal = datos.nombreOriginal;
                        modelo.modificaContacto(nuevosDatos);
                    }

                }
                else if (o == 8) {
                    String busqueda = vista.buscarContacto();
                    List<Contacto> contactosEncontrados = modelo.buscarContactos(busqueda);


                    if (contactosEncontrados.isEmpty()) {
                        vista.imprimirNoExiste();
                    } else {
                        vista.imprimirContactosEncontrados(contactosEncontrados);
                    }


                }
                else if (o == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                vista.nextLine();
                vista.muestraErrorInput();
            }catch (IndexOutOfBoundsException e ){

                vista.muestraErrorInput();

            }catch(NumberFormatException e){

                vista.muestraErrorInput();

            }catch (NullPointerException e ){

                vista.muestraErrorInput();

            }
        }


    }

}


