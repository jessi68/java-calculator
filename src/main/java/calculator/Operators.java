package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Operators {
    private Queue<Operator> operators;

    public Operators() {
        this.operators = new LinkedList<>();
    }

    public void add(Operator operator) {
        operators.offer(operator);
    }

    public Operator remove() {
        return operators.poll();
    }

    public boolean isEmpty() {
        return operators.isEmpty();
    }
}
