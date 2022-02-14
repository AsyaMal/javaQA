package com_it.utils;

import com_it.dao.AccountDAO;
import com_it.dao.TransactionDAO;
import com_it.dao.UserDAO;

import java.sql.SQLException;

public class MenuService {

    UserDAO userDAO = new UserDAO();
    AccountDAO accountDAO = new AccountDAO();
    TransactionDAO transactionDAO = new TransactionDAO();

    public void createNewUser() {
        String name = ScannerSQL.scanName();
        String address = ScannerSQL.scanAddress();
        try {
            userDAO.addUserInUsers(name, address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAccount() {
        double balance = ScannerSQL.scanBalance();
        System.out.println("Enter currency: 1 - EUR, 2 - USD");
        String currency = ScannerSQL.scanCurrency();
        System.out.println("You currency: " + currency);
        int userId = 0;
        try {
            userId = userDAO.printAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            accountDAO.createAccountForUser(userId, balance, currency);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAccountInAnotherCurrency() {
        int userId = ScannerSQL.scanUserId();
        int accountId = ScannerSQL.scanAccountId();
        try {
            if (userDAO.isUserExists(userId)) {
                double balance = ScannerSQL.scanBalance();
                System.out.println("Enter currency: 1 - EUR, 2 - USD");
                String currency = ScannerSQL.scanCurrency();
                System.out.println("You currency: " + currency);
                if (accountDAO.isAccountExist(accountId) && !accountDAO.checkAccountCurrency(userId, currency)) {
                    accountDAO.createAccountForUser(userId, balance, currency);
                }
            } else {
                System.out.println("Create a new user and account");
                createNewUser();
                createAccount();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void increaseUserAccount() {
        double amount = ScannerSQL.scanAmountForTransaction();
        try {
            if (transactionDAO.createTransactionForUserAccount(ScannerSQL.scanAccountId(), amount)) {
                if (accountDAO.updateAccount(ScannerSQL.scanQuantityOfMoney(), ScannerSQL.scanUserId(),
                        ScannerSQL.scanCurrency())
                        && amount <= 100000000
                        && accountDAO.increaseAccount(ScannerSQL.scanInt(), ScannerSQL.scanQuantityOfMoney()) <= 2000000000) {
                    System.out.println("Operation completed successfully");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Error!");
    }

    public void decreaseUserAccount() {
        double amount = ScannerSQL.scanAmountForTransaction();
        try {
            if (transactionDAO.createTransactionForUserAccount(ScannerSQL.scanAccountId(), amount)) {
                if (accountDAO.updateAccount(ScannerSQL.scanQuantityOfMoney(), ScannerSQL.scanUserId(),
                        ScannerSQL.scanCurrency())
                        && amount <= 100000000
                        && accountDAO.decreaseAccount(ScannerSQL.scanInt(), ScannerSQL.scanQuantityOfMoney()) <= 2000000000) {
                    System.out.println("Operation completed successfully");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Error!");
    }

}
