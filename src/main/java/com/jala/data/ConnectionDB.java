/*
 * @(#) ConnectionDB.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class defines the connection and creation of the database.
 * @author by Cristian Lujan
 * @Version 0.0.1
 */
public class ConnectionDB {

    /**
     * Attribute to create the connection.
     */
    private static Connection connection;

    /**
     * Attribute for database connection.
     */
    private static ConnectionDB connectDB;

    /**
     * Constructor to initialize the database connection.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private ConnectionDB() throws SQLException, ClassNotFoundException {
        initialize();
    }

    /**
     * Method that returns the connection to the database.
     * @return Connection of Data Base.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ConnectionDB getInstance() throws SQLException, ClassNotFoundException {
        if (connectDB == null) {
            connectDB = new ConnectionDB();
        }
        return connectDB;
    }

    /**
     * Method where the connection to the database is generated and created.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private void initialize() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:dataSearch.db");
        Statement state = connection.createStatement();
        state.execute("CREATE TABLE if not exists criteriaSearchDB (id integer primary key autoincrement,criteria varchar(200));");
    }

    /**
     * Method of connecting to the class.
     * @return The connection
     */
    public Connection getConnection() {
        return connection;
    }
}
