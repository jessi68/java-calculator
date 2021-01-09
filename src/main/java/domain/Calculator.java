package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Calculator {

    public static int apply(Formula formula) {
        int first, second, result;
        List<Operator> operators = new ArrayList<>(formula.getOperators());
        List<Integer> numbers = new ArrayList<>(formula.getNumbers());

        for(Operator operator: operators) {
            first = numbers.remove(0);
            second = numbers.remove(0);
            result = operator.apply(first, second);
            numbers.add(0, result);
        }
        return numbers.get(0);
    }
}
