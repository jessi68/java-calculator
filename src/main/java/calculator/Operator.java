package calculator;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public enum Operator implements DoubleBinaryOperator {
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right);

    private static final int ZERO = 0;

    private String symbol;
    private DoubleBinaryOperator expression;

    Operator(String symbol, DoubleBinaryOperator expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Operator findOperatorBySymbol(String symbol) {
        return Arrays.stream(values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));
    }

    public double operate(double input1, double input2) {
        if (this == DIVIDE) {
            checkZero(input2);
        }
        return expression.applyAsDouble(input1, input2);
    }

    private static void checkZero(double input) {
        if (input == ZERO) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    @Override
    public double applyAsDouble(final double left, final double right) {
        return expression.applyAsDouble(left, right);
    }
}