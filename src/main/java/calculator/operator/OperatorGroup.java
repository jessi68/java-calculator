package calculator.operator;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum OperatorGroup {
    PLUS("+", Double::sum),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    public static final String NOT_EXIST_OPERATOR_MESSAGE = "는 등록되지 않은 연산자 입니다.";
    private final OperationStarategy operationStarategy;
    private final String delimiter;

    OperatorGroup(String delimiter, OperationStarategy operationStarategy) {
        this.delimiter = delimiter;
        this.operationStarategy = operationStarategy;
    }

    public static double operate(double a, String inputOperator, double b) {
        return findOperationStrategy(inputOperator)
                .operationStarategy
                .operate(a, b);
    }

    private static OperatorGroup findOperationStrategy(String inputOperator) {
        return Arrays.stream(values())
                .filter(operator -> operator.isEqual(inputOperator))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(inputOperator + NOT_EXIST_OPERATOR_MESSAGE));
    }

    private boolean isEqual(String op) {
        return this.delimiter.equals(op);
    }
}