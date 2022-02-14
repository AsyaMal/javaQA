package com_it.dao;

import com_it.ConnectionDB;

import java.sql.*;

import static com_it.constant.ConstantSQL.CREATE_USER_SQL;
import static com_it.constant.ConstantSQL.READ_ALL_USERS_SQL;

public class UserDAO extends ConnectionDB {
    Connection connection = ConnectionDB.getConnection();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    public void addUserInUsers(String name, String address) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(CREATE_USER_SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            int rows = preparedStatement.executeUpdate();
            if (rows == 1) System.out.printf("%d user added in Users%n", rows);
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            closePreparedStatement();
            closeConnection();
        }
    }

    public boolean isUserExists(int userid) throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Users WHERE userid = " + userid);
            if (resultSet.next()) {
                System.out.println("User exists");
                return true;
            } else {
                System.out.println("User doesn't exist");
                return false;
            }
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            closeStatement();
            closeResultSet();
            closeConnection();
        }
    }

    public int printAllUsers() throws SQLException {
        String sql = "SELECT * FROM Users";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(READ_ALL_USERS_SQL);
            int lastId = 1;
            while (resultSet.next()) {
                lastId = resultSet.getInt(1);
            }
            return lastId;
        } finally {
            closeStatement();
            closeResultSet();
            closeConnection();
        }
    }
}



