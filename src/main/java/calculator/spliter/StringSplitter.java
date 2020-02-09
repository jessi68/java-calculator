package calculator.spliter;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private static final String BLANK = " ";
    private static final String NUMBER_FORMAT = "\\d+";
    public static final String ERROR_MESSAGE_OPERATOR_PLACE = "연산자의 위치가 잘못되었습니다.";
    public static final String ERROR_MESSAGE_NUMBER_PLACE = "숫자의 위치가 잘못되었습니다.";

    public static List<String> split(String inputString) {
        String[] result = inputString.split(BLANK);
        validate(result);
        return Arrays.asList(result);
    }

    private static void validate(String[] equation) {
        for (int i = 0; i < equation.length; i++) {
            if (operatorPlaceError(i, equation[i])) {
                throw new IllegalArgumentException(ERROR_MESSAGE_OPERATOR_PLACE);
            }
            if (numberPlaceError(i, equation[i])) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_PLACE);
            }
        }
    }

    private static boolean operatorPlaceError(int idx, String equationElement) {
        return idx % 2 == 0 && isNotNumber(equationElement);
    }

    private static boolean numberPlaceError(int idx, String equationElement) {
        return idx % 2 != 0 && isNumber(equationElement);
    }

    private static boolean isNotNumber(String maybeNumber) {
        return !isNumber(maybeNumber);
    }

    private static boolean isNumber(String maybeNumber) {
        return maybeNumber.matches(NUMBER_FORMAT);
    }
}