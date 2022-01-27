package calculator;

public class CalculatorRunner {
    public static void main(String[] args) {
        double number1 = NumberScanner.getNumber();
        double number2 = NumberScanner.getNumber();
        Calculator calc = new Calculator(number1,number2);
        char operation = ArithmeticOperation.getOperation();
        double result = ArithmeticOperation.getResult(ArithmeticOperation.calculate(number1, number2, operation));
        System.out.println("The result: " +calc.getFirstnumber() + " " + operation + " " + calc.getSecondnumber() + " = " + result);
    }
}
