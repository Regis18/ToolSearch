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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * This class defines the Querys Generals for the database
 * @author by Cristian Lujan
 * @Version 21/02/2019/C
 */

public class QueryGeneral {

    private Connection connection;

    /**
     * Constructor to initialize the connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public QueryGeneral() throws SQLException, ClassNotFoundException {
        connection = ConnectionDB.getInstance().getConnection();
    }

    /**
     * Method
     * @return
     * @throws SQLException
     */
    public ResultSet displayData() throws SQLException {
        Statement state = connection.createStatement();
        ResultSet resSet = ((Statement) state).executeQuery("SELECT id, criteria fileName FROM criteriaSearch");
        return resSet;
    }

    /**
     *
     * @param criteriaJson
     * @throws SQLException
     */
    public void addCriteria(String criteriaJson) throws SQLException {
        PreparedStatement prepared = connection.prepareStatement("INSERT INTO criteriaSearch(id, criteria) values(?,?);");
        prepared.setInt(1, 1);
        prepared.setString(2, criteriaJson);
        prepared.execute();
    }

    /**
     *
     * @param criteriaJson
     * @throws SQLException
     */
    public void updateCriteria(String criteriaJson) throws SQLException {
        PreparedStatement prepared = connection.prepareStatement("UPDATE criteriaSearch SET criteria = ? ");
        prepared.setString(2, criteriaJson);
        prepared.executeUpdate();
    }

    /**
     *
     * @param idCriteria
     * @throws SQLException
     */
    public void deleteCriteria(int idCriteria) throws SQLException {
        PreparedStatement prepared = connection.prepareStatement("DELETE FROM criteriaSearch WHERE id = ?;");
        prepared.setInt(1,idCriteria);
        prepared.execute();
    }
}