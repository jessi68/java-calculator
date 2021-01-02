package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Calculator {
    public enum Operator {
        PLUS("+") {
            public int apply(int x, int y) {return x + y;}
        },
        MINUS("-") {
            public int apply(int x, int y) {return x - y;}
        },
        DIVIDE("/") {
            public int apply(int x, int y) {return x / y;}
        },
        MULTIPLY("*") {
            public int apply(int x, int y) {return x * y;}
        };

        private String mark;

        Operator(String mark) {
            this.mark = mark;
        }

        @Override public String toString() { return this.mark; }

        public static Operator fromMark(String mark) {
            return Arrays.stream(values())
                         .findFirst()
                         .filter(operator -> operator.mark.equals(mark))
                         .get();
        }

        public abstract int apply(int x, int y);
    }


    public static int apply(List<Integer> numbers, List<Operator> operators) {
        int first, second, result;
        for(Operator operator: operators) {
            first = numbers.remove(0);
            second = numbers.remove(1);
            result = operator.apply(first, second);
            numbers.add(0, result);
        }
        return numbers.get(0);
    }
}
