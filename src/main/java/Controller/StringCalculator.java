package Controller;

import Model.Operator;
import View.OutputView;


import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private List<Integer> numbers = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();

    public void run() {
        initializeInputs();
        OutputView.printOutputMessage(calculate());
    }

    /**
     * 입력값 예외처리 후 숫자와 연산자를 분리
     */
    private void initializeInputs() {
        String[] inputs = InputValidation.checkValidation();
        for (String val : inputs) {
            try {
                numbers.add(Integer.parseInt(val));
            } catch (Exception e) {
                operators.add(Operator.from(val));
            }
        }
    }

    public double calculate() {
        double result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operators.get(i).compute(result, numbers.get(i+1));
        }
        return result;
    }
}
