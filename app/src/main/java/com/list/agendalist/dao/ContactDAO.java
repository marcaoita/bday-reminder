package com.list.agendalist.dao;

import com.list.agendalist.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    private final static List<Contact> contacts = new ArrayList<>();

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> returnStaticContactList() {
        return new ArrayList<>(contacts);
    }
}
