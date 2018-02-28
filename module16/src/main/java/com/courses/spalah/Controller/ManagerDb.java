package com.courses.spalah.Controller;

import com.courses.spalah.Model.Person;

import java.io.IOException;
import java.sql.*;

public class ManagerDb {
    private Connection connection;

    public ManagerDb() {
    }

    public void addPersonInAddressBook(String name, String lastName, String address) throws SQLException, IOException, ClassNotFoundException {
        ConnectionDb connectionDb = new ConnectionDb();
        this.connection = connectionDb.getConnection();

        final String INSERT_PERSON = "INSERT INTO people.address (address) VALUE (?)";
        final String INSERT_ADDRESS = "INSERT INTO people.person (first_name, last_name, address_id) VALUE (?, ?, ?)";

        PreparedStatement addressToSave = connection.prepareStatement(INSERT_PERSON,
                Statement.RETURN_GENERATED_KEYS);
        addressToSave.setString(1, address);
        addressToSave.execute();

        ResultSet resultSet = addressToSave.getGeneratedKeys();
        resultSet.next();
        int addressId = resultSet.getInt(1);

        PreparedStatement personToSave = connection.prepareStatement(INSERT_ADDRESS);

        personToSave.setString(1, name);
        personToSave.setString(2, lastName);
        personToSave.setInt(3, addressId);
        personToSave.execute();

        addressToSave.close();
        connection.close();
    }

    public Person searchPersonById(int id) throws SQLException, IOException, ClassNotFoundException {
        final String firstNameColumn = "first_name";
        final String lastNameColumn = "last_name";
        final String addressColumn = "address";
        final String SEARCH_PERSON = "SELECT * FROM people.person LEFT OUTER JOIN people.address "
                + "ON people.person.address_id = people.address.id WHERE people.person.id = ?";

        ConnectionDb connectionDb = new ConnectionDb();
        this.connection = connectionDb.getConnection();

        Person model = new Person();
        PreparedStatement personById = connection.prepareStatement(SEARCH_PERSON);
        personById.setInt(1, id);
        ResultSet result = personById.executeQuery();
        result.next();

        if (result.first()) {
            model.setName(result.getString(firstNameColumn));
            model.setLastName(result.getString(lastNameColumn));
            model.setAddress(result.getString(addressColumn));
        } else model = null;

        personById.close();
        connection.close();

        return model;
    }
}