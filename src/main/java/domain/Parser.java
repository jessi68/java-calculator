package domain;

import java.util.Arrays;

public class Parser {
    private static final String OPERATOR_DELIMITER = "\\+|-|/|\\*";
    private static final String NUMBER_DELIMITER = "\\d+";

    public Parser() {

    }

    public int [] parseIntegers(String request) {
        return (Arrays.stream(request.split(OPERATOR_DELIMITER))
                      .mapToInt(number -> Integer.parseInt(number)))
                      .toArray();
    }

    public String [] parseOperators(String request) {
        return (Arrays.stream(request.substring(1).split(NUMBER_DELIMITER)))
                                 .toArray(String[]::new);
    }
}
