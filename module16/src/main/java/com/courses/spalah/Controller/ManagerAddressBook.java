package com.courses.spalah.Controller;

import com.courses.spalah.Model.Person;
import com.courses.spalah.View.FrameAddressBook;

public class ManagerAddressBook {
    private FrameAddressBook view;
    private Person model;

    public ManagerAddressBook(FrameAddressBook view, Person model) {
        this.view = view;
        this.model = model;
    }
}
