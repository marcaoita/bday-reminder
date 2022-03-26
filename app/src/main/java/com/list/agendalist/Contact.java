package com.list.agendalist;

public class Contact {
    private String name;
    private String phone;
    private String bday;
    private String email;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getBday() {
        return bday;
    }

    public String getEmail() {
        return email;
    }

    public Contact(String name, String phone, String bday, String email) {
        this.name = name;
        this.phone = phone;
        this.bday = bday;
        this.email = email;
    }

    @Override
    public String toString() {
        return name;
    }
}
