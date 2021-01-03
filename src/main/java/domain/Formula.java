package domain;

import java.text.Normalizer.Form;
import java.util.List;

public class Formula {
    private final List<Integer> numbers;
    private final List<Operator> operators;

    public Formula(List<Integer> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Operator> getOperators() {
        return this.operators;
    }
}
