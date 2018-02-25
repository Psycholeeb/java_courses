package com.courses.spalah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.sql.SQLException;

public class FrameAddressBook implements ActionListener {
    private JTextField inputName, inputLastName, inputAddress, inputSearchId;
    private JLabel outputName, outputLastName, outputAddress;
    private DbManager dbManager = new DbManager();

    public FrameAddressBook() throws SQLException, ClassNotFoundException, IOException {
        JFrame mainFrame = new JFrame("Адресная книга");
        mainFrame.setBounds(400, 300, 600, 200);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container mainContainer = new Container();
        Container inputBlockInfo = new Container();
        Container outputBlockInfo = new Container();

        mainContainer.setLayout(new GridLayout(2,1,20,30));
        inputBlockInfo.setLayout(new GridLayout(1,1,10,30));
        outputBlockInfo.setLayout(new GridLayout(1,1,10,30));

        mainFrame.getContentPane().add(CreateElements(inputBlockInfo, outputBlockInfo, mainContainer));
        mainFrame.setVisible(true);
    }

    private Container CreateElements(Container inputContainer, Container outputContainer, Container mainContainer) {

        JButton buttonSave = new JButton("Сохранить");
        buttonSave.setFocusPainted(false);
        buttonSave.addActionListener(this);
        inputContainer.add(buttonSave);

        inputName = new JTextField("Имя");
        inputName.addFocusListener(focusListener);
        inputContainer.add(inputName);

        inputLastName = new JTextField("Фамилия");
        inputLastName.addFocusListener(focusListener);
        inputContainer.add(inputLastName);

        inputAddress = new JTextField("Адрес");
        inputAddress.addFocusListener(focusListener);
        inputContainer.add(inputAddress);

        JButton buttonSearch = new JButton("Найти");
        buttonSearch.setFocusPainted(false);
        buttonSearch.addActionListener(this);
        outputContainer.add(buttonSearch);

        inputSearchId = new JTextField("ID");
        inputSearchId.addFocusListener(focusListener);
        outputContainer.add(inputSearchId);

        outputName = new JLabel("Имя в БД", SwingConstants.CENTER);
        outputContainer.add(outputName);

        outputLastName = new JLabel("Фамилия в БД", SwingConstants.CENTER);
        outputContainer.add(outputLastName);

        outputAddress = new JLabel("Адрес в БД", SwingConstants.CENTER);
        outputContainer.add(outputAddress);

        mainContainer.add(inputContainer);
        mainContainer.add(outputContainer);

        return mainContainer;
    }

    private FocusListener focusListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (e.getComponent().equals(inputName))
                inputName.setText("");
            if (e.getComponent().equals(inputLastName))
                inputLastName.setText("");
            if (e.getComponent().equals(inputAddress))
                inputAddress.setText("");
            if (e.getComponent().equals(inputSearchId))
                inputSearchId.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Сохранить":
                try {
                    dbManager.addPersonInAddressBook(inputName.getText(),
                            inputLastName.getText(),
                            inputAddress.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(new JOptionPane(),
                            "Контакт сохранен!",
                            "Инфо", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Найти":
                try {
                    Person person = dbManager.searchPersonById(Integer.parseInt(inputSearchId.getText()));

                    if(person != null) {
                        outputName.setText(person.getName());
                        outputLastName.setText(person.getLastName());
                        outputAddress.setText(person.getAddress());
                    } else {
                        JOptionPane.showMessageDialog(new JOptionPane(),
                                "Контакт с таким ID не найден!",
                                "Инфо", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }
}
