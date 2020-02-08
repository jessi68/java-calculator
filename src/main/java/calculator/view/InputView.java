package calculator.view;

import java.util.Scanner;

public class InputView {

    public static String inputEquation() {
        System.out.println("계산할 수식을 입력해주세요. (숫자와 연산자는 공백으로 구분)");
        System.out.println("예시> 1 + 2");
        String equation = new Scanner(System.in).nextLine().trim();
        return validate(equation);
    }

    private static String validate(String equation) {
        if (equation.isEmpty()) {
            OutputView.printMessage_EmptyCase();
            throw new IllegalArgumentException("빈 문자열");
        }
        return equation;
    }
}
