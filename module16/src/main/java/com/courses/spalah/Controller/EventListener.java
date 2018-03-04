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
    private Person model;

    public EventListener(FrameAddressBook view, Person model) {
        this.view = view;
        this.model = model;
    }

    public void initController() {
        view.getInputName().addFocusListener(this);
        view.getInputLastName().addFocusListener(this);
        view.getInputAddress().addFocusListener(this);
        view.getInputSearchId().addFocusListener(this);
        view.getButtonSave().addActionListener(this);
        view.getButtonSearch().addActionListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getComponent() instanceof JTextField) {
            ((JTextField) e.getComponent()).setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Сохранить":
                view.showMessageCompleteSave();
                try {
                    sendRequestDb().addPersonInAddressBook(view.getInputName().getText(),
                            view.getInputLastName().getText(),
                            view.getInputAddress().getText());
                } catch (SQLException | IOException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;

            case "Найти":
                try {
                    this.model = sendRequestDb().searchPersonById(Integer.parseInt(view.getInputSearchId().getText()),
                            this.model);

                    if(this.model != null) {
                        view.getOutputName().setText(this.model.getName());
                        view.getOutputLastName().setText(this.model.getLastName());
                        view.getOutputAddress().setText(this.model.getAddress());
                    } else  view.showMessageContactNotFound();

                } catch (SQLException | IOException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }

    private RequestDb sendRequestDb() throws SQLException, IOException, ClassNotFoundException {
        ConnectionDb connectionDb = new ConnectionDb();
        RequestDb requestDb = new RequestDb(connectionDb);

        return requestDb;
    }
}
