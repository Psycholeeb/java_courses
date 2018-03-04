package com.courses.spalah;

import com.courses.spalah.Controller.EventListener;
import com.courses.spalah.Model.Person;
import com.courses.spalah.View.FrameAddressBook;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        FrameAddressBook view = new FrameAddressBook();
        Person model = new Person();
        EventListener controller = new EventListener(view, model);

        controller.initController();
    }
}
