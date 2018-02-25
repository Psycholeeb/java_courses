package com.courses.spalah;

import java.sql.*;

public class DbManager {
    private Connection connection;

    public DbManager() throws SQLException, ClassNotFoundException {
        DbConnection dbConnection = new DbConnection();
        this.connection = dbConnection.getConnection();
    }

    public void addPersonInAddressBook(String name,
                                       String lastName,
                                       String address) throws SQLException {

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
    }

    public Person searchPersonById(int id) throws SQLException {
        final String SEARCH_PERSON = "SELECT * FROM people.person LEFT OUTER JOIN people.address " +
                "ON people.person.address_id = people.address.id WHERE people.person.id = ?";

        Person person = new Person();
        PreparedStatement personById = connection.prepareStatement(SEARCH_PERSON);
        personById.setInt(1, id);
        ResultSet result = personById.executeQuery();
        result.next();

        if (result.first()) {
            person.setName(result.getString("first_name"));
            person.setLastName(result.getString("last_name"));
            person.setAddress(result.getString("address"));
        } else
            person = null;

        return person;
    }
}