package domain;

import java.util.function.BiFunction;

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
        public abstract int apply(int x, int y);
    }


    public static int apply() {

    }
}
