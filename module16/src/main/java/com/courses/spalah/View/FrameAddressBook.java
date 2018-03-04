package com.courses.spalah.View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class FrameAddressBook {
    private JTextField inputName, inputLastName, inputAddress, inputSearchId;
    private JLabel outputName, outputLastName, outputAddress;
    private JButton buttonSave, buttonSearch;

    public FrameAddressBook() throws SQLException, ClassNotFoundException, IOException {
        JFrame mainFrame = new JFrame("Адресная книга");
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 200);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

        buttonSave = new JButton("Сохранить");
        buttonSave.setFocusPainted(false);

        inputName = new JTextField("Имя");
        inputLastName = new JTextField("Фамилия");
        inputAddress = new JTextField("Адрес");

        buttonSearch = new JButton("Найти");
        buttonSearch.setFocusPainted(false);

        inputSearchId = new JTextField("ID");
        outputName = new JLabel("Имя в БД");
        outputLastName = new JLabel("Фамилия в БД");
        outputAddress = new JLabel("Адрес в БД");

        GroupLayout layout = new GroupLayout(mainFrame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inputName)
                        .addComponent(buttonSave)
                        .addComponent(buttonSearch)
                        .addComponent(outputName))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inputLastName)
                        .addComponent(inputSearchId)
                        .addComponent(outputLastName))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inputAddress)
                        .addComponent(outputAddress)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(inputName)
                        .addComponent(inputLastName)
                        .addComponent(inputAddress))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonSave))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonSearch)
                        .addComponent(inputSearchId))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(outputName)
                        .addComponent(outputLastName)
                        .addComponent(outputAddress)));
        layout.linkSize(inputName, inputLastName, inputAddress, inputSearchId,
                outputName, outputLastName, outputAddress, buttonSave, buttonSearch);
        mainFrame.getContentPane().setLayout(layout);
    }

    public void showMessageCompleteSave() {
        JOptionPane.showMessageDialog(new JOptionPane(),
                "Контакт сохранен!",
                "Инфо", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMessageContactNotFound() {
        JOptionPane.showMessageDialog(new JOptionPane(),
                "Контакт с таким ID не найден!",
                "Инфо", JOptionPane.INFORMATION_MESSAGE);
    }

    public JTextField getInputName() {
        return inputName;
    }

    public JTextField getInputLastName() {
        return inputLastName;
    }

    public JTextField getInputAddress() {
        return inputAddress;
    }

    public JTextField getInputSearchId() {
        return inputSearchId;
    }

    public JLabel getOutputName() {
        return outputName;
    }

    public JLabel getOutputLastName() {
        return outputLastName;
    }

    public JLabel getOutputAddress() {
        return outputAddress;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public JButton getButtonSearch() {
        return buttonSearch;
    }
}
