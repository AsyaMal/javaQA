package calculator;

public class Calculator {
    private final double number1;
    private final double number2;

    public Calculator(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public double getFirstnumber() {
        return this.number1;
    }

    public double getSecondnumber() {
        return this.number2;
    }
}
