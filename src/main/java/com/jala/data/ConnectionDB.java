/**
 * @(#)ConnectionDB.java Copyright (c) 2019 Jala Foundation.
2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
All rights reserved.
 *
 * This software is the confidential and proprietary information of
Jala Foundation, ("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into
with Jala Foundation.
 */
package com.jala.data;
import java.sql.*;

/**
 * @Version
 * @author by Cristian Lujan
 *
 */
public class ConnectionDB {

    private static Connection connection;
    private static ConnectionDB connectDB;

    private ConnectionDB() throws SQLException, ClassNotFoundException {
        initialize();
    }

    public static ConnectionDB getInstance() throws SQLException, ClassNotFoundException {
        if (connectDB == null) {
            connectDB = new ConnectionDB();
        }
        return connectDB;
    }

    private void initialize() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:dataSearch.db");
        Statement state = connection.createStatement();
        state.execute("CREATE TABLE if not exist criteriaSearch (id integer," + "criteria varchar(200)," + "primary key(id));");
    }

    public Connection getConnection(){
        return connection;
    }


}
