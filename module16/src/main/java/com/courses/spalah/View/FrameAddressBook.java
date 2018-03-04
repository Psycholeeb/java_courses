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
        buttonSave = new JButton("Сохранить");
        buttonSave.setFocusPainted(false);
        inputContainer.add(buttonSave);

        inputName = new JTextField("Имя");
        inputContainer.add(inputName);

        inputLastName = new JTextField("Фамилия");
        inputContainer.add(inputLastName);

        inputAddress = new JTextField("Адрес");
        inputContainer.add(inputAddress);

        buttonSearch = new JButton("Найти");
        buttonSearch.setFocusPainted(false);
        outputContainer.add(buttonSearch);

        inputSearchId = new JTextField("ID");
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
