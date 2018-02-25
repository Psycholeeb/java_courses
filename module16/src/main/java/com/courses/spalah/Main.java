package com.courses.spalah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Stupak Vlad
 */

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new FrameAddressBook();
    }
}
