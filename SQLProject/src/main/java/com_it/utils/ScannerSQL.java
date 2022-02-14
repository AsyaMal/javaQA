package com_it.utils;

import java.util.Scanner;

public class ScannerSQL {

    public static String scanString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int scanInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String scanName() {
        System.out.println("Enter name");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String scanAddress() {
        System.out.println("Enter address");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int scanUserId() {
        System.out.println("Enter userid");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int scanAccountId() {
        System.out.println("Enter accountid");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static double scanBalance() {
        System.out.println("Enter balance");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static double scanAmountForTransaction() {
        System.out.println("Enter amount for transaction");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static double scanQuantityOfMoney() {
        System.out.println("Enter quantity of money");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static String scanCurrency() {
        int operation = 0;
        String choice = "";
        while (true) {
            choice = scanString();
            try {
                operation = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Error, enter only number of operation");
            }
            switch (operation) {
                case 1:
                    return "EUR";
                case 2:
                    return "USD";
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
        }
    }
}
