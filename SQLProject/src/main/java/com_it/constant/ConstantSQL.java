package com_it.constant;

public class ConstantSQL {
    public static final String CREATE_USER_SQL = "INSERT INTO Users (name, address) VALUES (?,?)";
    public static final String READ_ALL_USERS_SQL = "SELECT * FROM Users";
    public static final String CREATE_ACCOUNT_SQL = "INSERT INTO Accounts (userid, balance, currency) VALUES (?,?,?)";
    public static final String READ_ACCOUNT_SQL = "SELECT * FROM Accounts WHERE userid = ? + AND currency = ?";
    public static final String UPDATE_ACCOUNT_SQL = "UPDATE Accounts SET balance = ? WHERE userid = ? AND currency = ?";
    public static final String CREATE_TRANSACTION_SQL = "INSERT INTO Transactions (accountid, amount) VALUES (?,?)";
}
