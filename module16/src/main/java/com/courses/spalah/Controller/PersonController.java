package com.courses.spalah.Controller;

import com.courses.spalah.Model.Person;
import com.courses.spalah.View.FrameAddressBook;

public class PersonController {
    private Person model;
    private FrameAddressBook view;

    public PersonController(Person model, FrameAddressBook view) {
        this.model = model;
        this.view = view;
    }

    public void setName(String name) {
        model.setName(name);
    }

    public String getName() {
        return model.getName();
    }

    public void setLastName(String lastName) {
        model.setLastName(lastName);
    }

    public String getLastName() {
        return model.getLastName();
    }

    public void setAddress(String address) {
        model.setAddress(address);
    }

    public String getAddress() {
        return model.getAddress();
    }
}
