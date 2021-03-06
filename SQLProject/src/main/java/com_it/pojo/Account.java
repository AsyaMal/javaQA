package com_it.pojo;

public class Account {
    private int accountId;
    private int userId;
    private double balance;
    private String currency;

    public Account() {

    }

    public Account(int accountId, int userId, double balance, String currency) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
        this.currency = currency;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountID) {
        this.accountId = accountID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountid=" + accountId +
                ", userid=" + userId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }

    public void getCurrency(String scanCurrency) {
    }
}
