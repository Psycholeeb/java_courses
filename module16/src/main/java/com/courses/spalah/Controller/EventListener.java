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
                    Person model = new Person();
                    model = sendRequestDb().searchPersonById(Integer.parseInt(view.getInputSearchId().getText()),
                            model);

                    if(model != null) {
                        view.getOutputName().setText(model.getName());
                        view.getOutputLastName().setText(model.getLastName());
                        view.getOutputAddress().setText(model.getAddress());
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
