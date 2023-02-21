package org.benigaslo;

import org.benigaslo.model.Agenda;
import org.benigaslo.model.Contacto;

import java.util.List;

public class  RellenadorDeAgendas {
    void rellenar(List<Agenda> agendas) {

        Agenda agenda1 = new Agenda("Personal", "Mis amigos personales");
        Agenda agenda2 = new Agenda("Work", "Mis compañeros de trabajo");

        Contacto contacto1 = new Contacto("Juan", "34234234");
        Contacto contacto2 = new Contacto("Pepe", "1212312");
        Contacto contacto3 = new Contacto("Anna", "54466");
        Contacto contacto4 = new Contacto("Luis", "0989089");

        agenda1.contactos.add(contacto1);
        agenda1.contactos.add(contacto2);
        agenda1.contactos.add(contacto4);

        agenda2.contactos.add(contacto3);
        agenda2.contactos.add(contacto4);

        agendas.add(agenda1);
        agendas.add(agenda2);
    }
}
