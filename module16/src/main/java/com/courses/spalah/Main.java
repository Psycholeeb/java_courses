package com.courses.spalah;

import com.courses.spalah.Controller.EventListener;
import com.courses.spalah.View.FrameAddressBook;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        FrameAddressBook view = new FrameAddressBook();
        EventListener controller = new EventListener(view);

        controller.initController();
    }
}
