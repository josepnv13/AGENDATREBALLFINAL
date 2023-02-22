package org.benigaslo.view;

import org.benigaslo.controller.AgendaDTO;
import org.benigaslo.controller.ModificacionDTO;
import org.benigaslo.controller.NuevoContactoDTO;
import org.benigaslo.model.Agenda;
import org.benigaslo.model.Contacto;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class Vista {
    Scanner scanner = new Scanner(System.in);

    public void muestraErrorInput() {
        error("Not a correct option! Try again");
    }

    public void muestraErrorNoAgendas() {
        error("No tienes ninguna agenda creada");
    }

    void error(String texto) {
        System.out.println(RED + "\uD83D\uDEA8 ERROR: " + texto);
    }

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public void mostrarMenu() {
        System.out.println("\u001B[33m"+"++++++++++++++++++++++++++++++++++++");
        System.out.println("[31m"+"*****MENU*****"+"\u001B[0m");
        System.out.println("\u001B[35m"+"Cercar:\n"+"\u001B[0m"+"0."+"❌" +"Cerrar programa \n" + "1."+"➕"+" Añadir contacto\n" +
                "2."+"\uD83D\uDDD1"+" Eliminar contacto\n" +
                "3."+"\uD83D\uDC40"+ "Ver contactos\n" +
                "4."+"➕"+"Crear nueva agenda\n" +
                "5."+"\uD83D\uDC40"+" Ver agendas\n" +
                "6."+"\uD83D\uDDD1" +"Eliminar agendas\n" +
                "7."+"\uD83D\uDD04"+"Modificar contacto\n" +
                "8."+"\uD83D\uDD0D"+"Buscar contacto");
    }




    public int pedirOpcion() {
        System.out.println("\u001B[33m"+"++++++++++++++++++++++++++++++++++++"+"\u001B[0m");
        System.out.println("\u001B[34m"+"Opcion: "+ "\u001B[0m");
        int opcion = scanner.nextInt();
        scanner.nextLine();


        return opcion;
    }

    public void mostrarAgendas(List<Agenda> agendas) {
        System.out.println("LISTA DE AGENDAS\uD83D\uDCD2");

        agendas.forEach(agenda -> System.out.println(agenda.nombre + " : " + agenda.descripcion));
    }

    public AgendaDTO pedirDatosAgendaNueva() {
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Info: ");
        String ciudad = scanner.nextLine();

        return new AgendaDTO(nombre, ciudad);

    }

    public NuevoContactoDTO muestraPantallaAnyadirContacto(List<Agenda> joseps) {
        System.out.println("\u001B[36m"+"*** Añadir contacto***");
        System.out.println("Selecione agenda\uD83D\uDCD2:");
        int contador=0;

        for (Agenda agenda : joseps) {
            System.out.println(contador++ +"." +" "+agenda.nombre);
        }

        System.out.println("Opcion: ");

        String numerosDeAgenada = scanner.nextLine();

        System.out.println("Nombre: ");
        String nombreContacto = scanner.nextLine();
        System.out.println("**************************************");
        System.out.println("\uD83D\uDCDETelefono: "+"\u001B[0m");
        String nombreTelefono = scanner.nextLine();


        return new NuevoContactoDTO(numerosDeAgenada, nombreContacto, nombreTelefono);

    }

    public void mostrarAgenda(Agenda agenda) {
        System.out.println("VIENDO LA AGENDA\uD83D\uDCD2 " + agenda.nombre);

        System.out.println("CONTACTOS: ");

        for (Contacto contacto : agenda.contactos) {

            System.out.println("Nombre: " + contacto.nombre);
            System.out.println("\uD83D\uDCDETelefono: " + contacto.telefono);
            System.out.println("--------------------------------------------------------");

        }


    }

    public int pedirQueAgendaQuiereVer(List<Agenda> agendas) {
        System.out.println("\033[1;34m"+"Que agenda quieres ver?\uD83D\uDCD2");
        int contador = 0;

        for (Agenda agenda : agendas) {
            System.out.println((contador++) + "." + agenda.nombre);
        }


        int numeroAgenda = scanner.nextInt();
        scanner.nextLine();

        return numeroAgenda;
    }

    public void voreLlistaAgendes(List<Agenda> agendas) {
        if (agendas.size() == 0) {
           error("No tiene ninguna agenda");
        } else {
            System.out.println("Ustd tiene estas agendas: ");
            agendas.forEach(agenda -> System.out.println("\033[0;37m"+agenda.nombre + "--------------" + agenda.descripcion+"\u001B[0m"));
        }
    }

    public String pedirContactoeliminar() {

        System.out.println("Que contacto quiere eliminar?");

        String nomEliminar = scanner.nextLine();

        return nomEliminar;
    }

    public String pedirAgendaAEliminar() {

        System.out.println("Que agenda quieres eliminar?");

        String nomEliminaragenda = scanner.nextLine();

        return nomEliminaragenda;

    }

    public void cercarMenu() {
    }

    public void imprimirNoExiste(){

        error("Este contacto no existe");

    }

    public ModificacionDTO pedirDatosModificacion() {

        System.out.println("Nombre de contacto a modificar:");
        String eliminar = scanner.nextLine();

        return new ModificacionDTO(eliminar);
    }

    public ModificacionDTO pedirDatosqueQuedan(){
        System.out.println("Nuevo nombre del contacto(puede estar vacio):");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Nuevo telefono del contacto(puede estar vacio):");
        String nuevonumtlf = scanner.nextLine();
        return new ModificacionDTO(nuevoNombre, nuevonumtlf);

    }

    public String buscarContacto() {
        System.out.println("Para buscar un contacto ponga su nombre o telefono: ");
        return scanner.next();
    }

    public void imprimirContactosEncontrados(List<Contacto> contactosEncontrados) {
        System.out.println("Se han encontrado estos contactos: ");
        contactosEncontrados.forEach(contacto -> System.out.println(contacto.nombre + " ----- " + contacto.telefono));

    }

    public void nextLine() {
        scanner.nextLine();
    }
}



/*
dddd

Cercar:
1. Añadir contacto
2. Eliminar contacto
3. Ver contactos
4. Crear nueva agenda
5. Ver agendas
6. Eliminar agendas
7. Modificar


Nombre del contacto a modicar:
Juan

Nuevo nombre (deja en blanco para no modificar):
Pepe
Nuevo telefono (deja en blanco para no modificar):
345345





 */