package com.courses.spalah.Controller;

import com.courses.spalah.Model.RequestDb;
import com.courses.spalah.Model.Person;
import com.courses.spalah.View.FrameAddressBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.sql.SQLException;

public class EventListener implements FocusListener, ActionListener{
    private FrameAddressBook view;

    public EventListener(FrameAddressBook view) {
        this.view = view;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getComponent() instanceof JTextField) {
            JTextField jTextField = (JTextField) e.getComponent();
            jTextField.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        RequestDb requestDb = new RequestDb();

        switch (actionCommand) {
            case "Сохранить":
                view.showMessageCompleteSave();
                try {
                    requestDb.addPersonInAddressBook(view.getInputName().getText(),
                            view.getInputLastName().getText(),
                            view.getInputAddress().getText());
                } catch (SQLException | IOException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;

            case "Найти":
                try {
                    Person person = requestDb.searchPersonById(Integer.parseInt(view.getInputSearchId().getText()));

                    if(person != null) {
                        view.getOutputName().setText(person.getName());
                        view.getOutputLastName().setText(person.getLastName());
                        view.getOutputAddress().setText(person.getAddress());
                    } else  view.showMessageContactNotFound();

                } catch (SQLException | IOException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }
}
