import domain.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Calculator Test")
public class CalculatorTest {


    @ParameterizedTest
    @CsvSource({"{1, 2}, {'+'}, 3",
                "{2, 4}, {'-'}, -2",
                "{3, 5}, {'*'}, 15",
                "{5, 7}, {'/'}, 5/7"})
    void individualOperationTest(int[] numbers, String[] operators, double answer) {
        double expected = Calculator.apply(numbers, operators);
        Assertions.assertEquals(answer, expected);
    }

    @ParameterizedTest
    @CsvSource({"{1, 2, 3}, {'+', '-'}, 0",
                "{2, 4, 5}, {'+', '*'}, 30",
                "{3, 5, 1}, {'+', '/'}, 15",
                "{5, 7, }, {'-', '*', '+'}, 5/7"})
    void severalOperationsTest(int[] numbers, String[] operators, double answer) {
        double expected = Calculator.apply(numbers, operators);
        Assertions.assertEquals(answer, expected);
    }

    @Test
    @ParameterizedTest
    @CsvSource({"{1, 2, 4, 0}, {'+', '-', '/'}"})
    void divideByZeroTest(int[] numbers, String[] operators) {
        boolean isError = false;
        try{
            Calculator.apply(numbers, operators);
        } catch(Exception e) {
            isError = true;
        }
        Assertions.assertEquals(isError, true);
    }
}
