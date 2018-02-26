package com.courses.spalah.Controller;

import com.courses.spalah.Model.Person;
import com.courses.spalah.View.FrameAddressBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EventListenerController implements FocusListener, ActionListener{
    private Person model;
    private FrameAddressBook view;

    public EventListenerController(Person model, FrameAddressBook view) {
        this.model = model;
        this.view = view;
    }

    public EventListenerController(FrameAddressBook view) {
        this.view = view;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getComponent().equals(view.getObjInputName()))
            view.setInputNameText("");
        if (e.getComponent().equals(view.getObjInputLastName()))
            view.setInputLastNameText("");
        if (e.getComponent().equals(view.getObjInputAddress()))
            view.setInputAddressText("");
        if (e.getComponent().equals(view.getObjInputSearchId()))
            view.setInputSearchIdText("");
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
                /*try {
                    managerDb.addPersonInAddressBook(inputName.getText(),
                            inputLastName.getText(),
                            inputAddress.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }*/
                break;
            case "Найти":
                view.showMessageContactNotFound();
                /*try {
                    Person person = managerDb.searchPersonById(Integer.parseInt(inputSearchId.getText()));

                    if(person != null) {
                        outputName.setText(person.getName());
                        outputLastName.setText(person.getLastName());
                        outputAddress.setText(person.getAddress());
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }*/
                break;
        }
    }
}
