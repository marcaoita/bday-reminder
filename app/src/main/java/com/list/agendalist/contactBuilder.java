package com.list.agendalist;

public class contactBuilder {

    //The constructor will initialize the newly created object
    public contactBuilder(String contactName, String contactPhone) {
        this.contactName = contactName;
        this.contactPhone = contactPhone;
    }

    //Getters so we can retrieve the info
    public String getContactName() {
        return contactName;
    }

    public String getContactPhone() {

        return contactPhone;
    }

    String contactName;
    String contactPhone;

}
