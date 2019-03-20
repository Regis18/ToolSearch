/*
 * @(#) QueryGeneral.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.utils.Logs;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * This class defines the Querys Generals for the database
 * @author by Cristian Lujan
 * @Version 0.0.1
 */
public class QueryGeneral {

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();

    /**
     * Attribute to create the connection.
     */
    private Connection connection;

    /**
     * Constructor to initialize the connection.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public QueryGeneral() {
        try {
            connection = ConnectionDB.getInstance().getConnection();
        } catch (SQLException event) {
            log.error("Error in: " + event.getMessage(), event);
        } catch (ClassNotFoundException event) {
            log.error("Error in: " + event.getMessage(), event);
        }
    }

    /**
     * Method to select an element from the database.
     * @return resultset
     * @throws SQLException
     */
    public ResultSet selectCriteria(int id) throws SQLException {
        PreparedStatement prepared = connection.prepareStatement("SELECT criteria FROM criteriaSearchDB WHERE id=?;");
        prepared.setInt(1, id);
        ResultSet resultset = prepared.executeQuery();
        return resultset;
    }

    /**
     * Method to add an element from the database
     * @param criteriaJson
     * @throws SQLException
     */
    public void addCriteria(String criteriaJson) throws SQLException {
        PreparedStatement prepared = connection.prepareStatement("INSERT INTO criteriaSearchDB(criteria) values(?);");
        prepared.setString(1, criteriaJson);
        prepared.execute();
    }

    /**
     * Method to remove an element from the database.
     * @param idCriteria
     * @throws SQLException
     */
    public void deleteCriteria(int idCriteria) throws SQLException {
        PreparedStatement prepared = connection.prepareStatement("DELETE FROM criteriaSearchDB WHERE id = ?;");
        prepared.setInt(1,idCriteria);
        prepared.execute();
    }

    /**
     * Obtains all of the values of the criteria.
     * @return ResultSet result
     * @throws SQLException
     */
    public ResultSet obtainDB() throws SQLException {
        Statement state = connection.createStatement();
        ResultSet resultSet = ((Statement) state).executeQuery("select * from criteriaSearchDB");
        return resultSet;
    }
}