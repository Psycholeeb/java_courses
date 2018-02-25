package com.courses.spalah;

import java.io.IOException;
import java.sql.*;

public class DbManager {
    private Connection connection;

    public DbManager() {

    }

    public void addPersonInAddressBook(String name, String lastName, String address) throws SQLException, IOException, ClassNotFoundException {
        DbConnection dbConnection = new DbConnection();
        this.connection = dbConnection.getConnection();

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

        DbConnection dbConnection = new DbConnection();
        this.connection = dbConnection.getConnection();

        Person person = new Person();
        PreparedStatement personById = connection.prepareStatement(SEARCH_PERSON);
        personById.setInt(1, id);
        ResultSet result = personById.executeQuery();
        result.next();

        if (result.first()) {
            person.setName(result.getString(firstNameColumn));
            person.setLastName(result.getString(lastNameColumn));
            person.setAddress(result.getString(addressColumn));
        } else person = null;

        personById.close();
        connection.close();

        return person;
    }
}