import static org.assertj.core.api.Assertions.assertThat;

import domain.Parser;

import java.lang.reflect.Array;
import java.util.Arrays;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Parser Test")
public class ParserTest {
    Parser parser = new Parser();

    void operatorTestHelper(String inputs[], int[] answer, int[] expected) {
        for(String input: inputs) {
            input = input.replaceAll("\\s+","");
            expected = parser.parseIntegers(input);
            Assertions.assertArrayEquals(expected, answer);
        }
    }

    @Test
    void splitWithUnitOperatorTest() {
        String inputs[] = {"1 + 3", "1 - 3", "1 * 3", "1 / 3"};
        int[] answer = {1, 3};
        int [] expected = null;
        operatorTestHelper(inputs, answer, null);
    }

    @Test
    void splitWithSeveralOperatorsTest() {
        String inputs[] = {"1 + 3 - 7 / 9 * 8"};
        int [] answer = {1, 3, 7, 9, 8};
        int [] expected = null;
        operatorTestHelper(inputs, answer, null);
    }

    void integerTestHelper(String[] inputs, String[] answer, String[] expected) {
        for(String input: inputs) {
            input = input.replaceAll("\\s+","");
            expected = parser.parseOperators(input);
            System.out.println(Arrays.toString(expected));
            Assertions.assertArrayEquals(expected, answer);
        }
    }

    @Test
    void splitWithSeveralIntegersTest() {
        String inputs[] = {"1 + 3 - 7 / 9 * 8"};
        String [] answer = {"+", "-", "/", "*"};
        String [] expected = null;
        integerTestHelper(inputs, answer, null);
    }


}
