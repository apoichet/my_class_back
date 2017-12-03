package fr.myclass.back.core.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by alex on 06/10/17.
 */
public class Tutor extends Person{

    private List<Contact> contacts;
    private Addresses adresses;

    public Tutor() {
    }

    public Tutor(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }


    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Addresses getAdresses() {
        return adresses;
    }

    public void setAdresses(Addresses adresses) {
        this.adresses = adresses;
    }
}
