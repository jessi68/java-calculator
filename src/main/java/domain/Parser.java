package domain;

import java.util.Arrays;

public class Parser {
    private static final String OPERATOR_DELIMITER = "\\+|\\-|\\/|\\*";


    public Parser() {

    }

    public int [] parseIntegers(String request) {

        return (Arrays.stream(request.split(OPERATOR_DELIMITER))
                     .mapToInt(number -> Integer.parseInt(number)))
                     .toArray();

    }

}
