package com.courses.spalah;

import com.courses.spalah.Model.Person;
import com.courses.spalah.View.FrameAddressBook;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        FrameAddressBook view = new FrameAddressBook();
        Person model = new Person();
        //EventListenerController eventListenerController = new EventListenerController(view);
    }
}
