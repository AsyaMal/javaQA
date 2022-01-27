package calculator;

import java.util.Scanner;

public class NumberScanner {
    static Scanner scanner = new Scanner(System.in);
    public static double getNumber() {
        System.out.print("Enter number: ");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Attention, incorrect values, enter number");
            scanner.next();
            number = getNumber();
        }
        return number;
    }
}
