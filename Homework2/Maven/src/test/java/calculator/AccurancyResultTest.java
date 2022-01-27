package calculator;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class AccurancyResultTest {
    @DisplayName("Calculation accuracy expected two decimal places")
    @Test
    public void testAccurancyResultTwoDecimalPlaces() {

        Assertions.assertEquals(3.33,
                ArithmeticOperation.getResult(ArithmeticOperation.calculate(10, 3, '/')), "Calculation accuracy isn't two decimal places");
    }
}
