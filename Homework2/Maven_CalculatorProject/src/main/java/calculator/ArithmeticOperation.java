package calculator;

import java.util.Scanner;

public class ArithmeticOperation {
    public static char getOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an operator (+, -, *, /): ");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Error! Please enter a correct operator");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calculate(double number1, double number2, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 == 0) {
                    System.out.println("Division by zero is not possible, please change the divisor");
                    System.exit(0);
                } else
                    result = number1 / number2;
                break;
            default:
                System.out.println("Error! Please enter a correct operator");
                result = calculate(number1, number2, getOperation());
        }
        return result;
    }

    public static double getResult(double result) {
        final int accurancy = 2;
        return Math.round((result) * (int) Math.pow(10.0, accurancy)) / Math.pow(10.0, accurancy);
    }
}