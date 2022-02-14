package com_it.dao;

import com_it.ConnectionDB;

import java.sql.*;

import static com_it.constant.ConstantSQL.*;

public class AccountDAO extends ConnectionDB {
    Connection connection = getConnection();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    public void createAccountForUser(int userId, double balance, String currency) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(CREATE_ACCOUNT_SQL);
            preparedStatement.setInt(1, userId);
            preparedStatement.setDouble(2, balance);
            preparedStatement.setString(3, currency);
            int rows = preparedStatement.executeUpdate();
            if (rows == 1) System.out.printf("%d user added in Accounts%n", rows);
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionDB.closePreparedStatement();
            closeConnection();
        }
    }

    public boolean checkAccountCurrency(int userId, String currency) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(READ_ACCOUNT_SQL);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, currency);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            closePreparedStatement();
            closeResultSet();
            closeConnection();
        }
    }

    public boolean updateAccount(double quantityOfMoney, int userId, String currencyAccount) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_SQL);
            preparedStatement.setDouble(1, quantityOfMoney);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, currencyAccount);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            closePreparedStatement();
            closeResultSet();
            closeConnection();
        }
    }

    public boolean isAccountExist(int accountId) throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Accounts WHERE accountid = " + accountId);
            if (resultSet.next()) {
                System.out.println("Account exists");
                return true;
            } else {
                System.out.println("Accounts doesn't exist");
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

    public double increaseAccount(int accountId, double amount) throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Accounts WHERE accountid = " + accountId);
            double resultOfTransaction = 0;
            while (resultSet.next()) {
                resultOfTransaction = (resultSet.getDouble(3) + amount);
            }
            return resultOfTransaction;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            closeStatement();
            closeResultSet();
            closeConnection();
        }
    }

    public double decreaseAccount(int accointId, double amount) throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Accounts WHERE accountid = " + accointId);
            double resultOfTransaction = 0;
            while (resultSet.next()) {
                resultOfTransaction = (resultSet.getDouble(3) - amount);
            }
            return resultOfTransaction;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            closeStatement();
            closeResultSet();
            closeConnection();
        }
    }
}


