package domain;

import java.util.Arrays;

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

