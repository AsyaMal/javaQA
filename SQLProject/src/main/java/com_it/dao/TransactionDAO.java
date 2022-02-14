package com_it.dao;

import com_it.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com_it.constant.ConstantSQL.CREATE_TRANSACTION_SQL;

public class TransactionDAO extends ConnectionDB {
    Connection connection = getConnection();
    private PreparedStatement preparedStatement;

    public boolean createTransactionForUserAccount(int accountId, double amount) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(CREATE_TRANSACTION_SQL);
            preparedStatement.setInt(1, accountId);
            preparedStatement.setDouble(2, amount);
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

}
