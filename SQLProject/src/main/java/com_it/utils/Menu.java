package com_it.utils;


public class Menu extends MenuService {

    public void start() {

        int operation = 0;
        String choice = "";

        while (!"0".equals(choice)) {
            System.out.println("Welcome in our program, you can: " + "\n" + "1 - Create a new user and add an account for a new user" + "\n" + "2 - Add an account in another currency for an user" + "\n" + "3 - Top up user's account" + "\n" +
                    "4 - Withdraw money from user's account" + "\n" + "0 - Exit" + "\n" + "Enter the operation number: ");
            choice = ScannerSQL.scanString();
            try {
                operation = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Error, enter only the number of operation");
            }
            switch (operation) {
                case 1:
                    createNewUser();
                    createAccount();
                    break;
                case 2:
                    createAccountInAnotherCurrency();
                    break;
                case 3:
                    increaseUserAccount();
                    break;
                case 4:
                    decreaseUserAccount();
                    break;
                case 0:
                    System.out.println("Good buy!");
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
        }
    }
}












