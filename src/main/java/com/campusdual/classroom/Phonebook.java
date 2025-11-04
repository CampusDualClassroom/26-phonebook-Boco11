package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, Contact> listado;

    public Phonebook() {
        this.listado = new HashMap<>();
    }

    public void addContact(Contact contact) {
        listado.put(contact.getCode(), contact);
    }

    public void deleteContact(String code) {
        listado.remove(code);
    }

    public void showPhonebook() {
        if (listado.isEmpty()) {
            System.out.println("No hay contactos.");
        } else {
            for (Contact c : listado.values()) {
                c.showContactDetails();
            }
        }
    }

    public Map<String, Contact> getData() {
        return listado;
    }
}

