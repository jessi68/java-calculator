package calculator.domain;

import calculator.view.OutputView;

import java.util.InputMismatchException;

enum Operators implements Operation {
    PLUS("+") {
        @Override
        public int operate(int a, int b) {
            return a + b;
        }
    },
    MINUS("-") {
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int operate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(int a, int b) {
            try {
                return a / b;
            } catch (ArithmeticException e) {
                OutputView.printMessage_DividedByZeroCase();
                throw e;
            }

        }
    };

    private static Operators[] operators = Operators.values();
    private final String symbol;

    Operators(String symbol) {
        this.symbol = symbol;
    }

    public boolean hasThis(String symbol) {
        return symbol.equals(this.symbol);
    }

    public static Operators findOperator(String symbol) {
        for (Operators op : operators) {
            if (op.hasThis(symbol)) {
                return op;
            }
        }
        OutputView.printMessage_InvalidEquationCase();
        throw new InputMismatchException("해당 연산자 없음");
    }
}
