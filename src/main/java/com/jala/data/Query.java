
package com.jala.data;
import java.sql.*;

public class Query {

    private Connection connection;
    public Query() throws SQLException, ClassNotFoundException {
        connection = ConnectionDB.getInstance().getConnection();
    }

    public ResultSet displayData() throws SQLException, ClassNotFoundException {
        Statement state = connection.createStatement();
        ResultSet resSet = state.executeQuery("SELECT id, criteria fileName FROM criteriaSearch");
        return resSet;
    }

    public void addCriteria(String criteriaJson) throws SQLException {
        PreparedStatement prepared = connection.prepareStatement("INSERT INTO criteriaSearch(id, criteria) values(?,?,?);");
        prepared.setString(2,criteriaJson);
        prepared.execute();
    }
}
