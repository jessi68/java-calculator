package calculator.domain;

import calculator.operator.OperatorGroup;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Equation {
    private static final int MIN_NUMBER_LIST_SIZE = 1;
    private Deque<Double> numbers;
    private Queue<String> operators;

    public Equation(List<Double> numbers, List<String> operators) {
        this.numbers = new LinkedList<>(numbers);
        this.operators = new LinkedList<>(operators);
    }

    public double getResult() {
        while (numbers.size() != MIN_NUMBER_LIST_SIZE) {
            numbers.addFirst(OperatorGroup.operate(numbers.pollFirst(), operators.poll(), numbers.pollFirst()));
        }
        return numbers.getFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation = (Equation) o;
        return Objects.equals(numbers, equation.numbers) &&
                Objects.equals(operators, equation.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, operators);
    }
}