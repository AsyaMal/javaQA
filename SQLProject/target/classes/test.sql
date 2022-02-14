PRAGMA foreign_keys = ON;
CREATE TABLE Users(
userid integer primary key autoincrement,
name varchar(50) NOT NULL,
address varchar(255)
);
CREATE TABLE Accounts(
accountid integer primary key autoincrement,
userid integer(10) NOT NULL,
balance decimal(18,3) NOT NULL,
currency varchar(10) NOT NULL,
FOREIGN KEY (userid)  REFERENCES Users (userid)
);
CREATE TABLE Transactions(
transactionid integer primary key autoincrement,
accountid integer(10) NOT NULL,
amount decimal(18,3) NOT NULL,
FOREIGN KEY (accountid)  REFERENCES Accounts (accountid)
);