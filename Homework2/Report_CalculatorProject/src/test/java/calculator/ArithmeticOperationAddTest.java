package calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)

public class ArithmeticOperationAddTest {
    private final double number1;
    private final double number2;
    private final char operation;
    private final double expectedResult;

    public ArithmeticOperationAddTest(double number1, double number2, char operation, double expectedResult) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{1, 2, '+', 3}, {1, -8, '+', -7}, {100, 200, '+', 300}};
        return Arrays.asList(data);
    }

    @Before
    public void init() throws Exception {
        ArithmeticOperation arithmeticOperation = new ArithmeticOperation();
    }

    @Test
    public void testAddUseTwoNumbers() {
        assertEquals(expectedResult,
                ArithmeticOperation.getResult(ArithmeticOperation.calculate(number1, number2, operation)));
    }


}
