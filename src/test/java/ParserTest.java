import domain.Parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Parser Test")
public class ParserTest {
    Parser parser = new Parser();

    @ParameterizedTest
    @CsvSource({"'1 + 2',{1, 2}", "'2 - 4', {2, 4}", "'3 * 5', {3, 5}", "'5 / 7', {5, 7}"})
    void splitWithUnitOperatorTest(String input, int [] answer) {
        int [] expected = parser.parseInteger(input);
        Assertions. assertArrayEquals(expected, answer);
    }

    @ParameterizedTest
    @CsvSource({"'1 + 2 * 3 - 5',{1, 2, 3, 5}", "'2 - 4 + 6', {2, 4, 6}"})
    void splitWithSeveralOperatorsTest(String input, int [] answer) {
        int [] expected = parser.parseInteger(input);
        Assertions. assertArrayEquals(expected, answer);
    }
}
