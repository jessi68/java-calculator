import domain.Calculator;
import domain.Formula;
import domain.Operator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calculate Test")
public class CalculateTest {
    Calculator calculator = new Calculator();

    int 공통_helper_함수(Integer[] numbers, Operator[] operators) {
        return calculator.apply(new Formula(Arrays.asList(numbers), Arrays.asList(operators)));
    }

    @Test
    @Ignore
    void 기본_사칙_연산_한개씩_테스트() {
        Integer[] nums = {1, 3};

        for(Operator operator: Operator.values()) {
            Assertions.assertEquals(operator.apply(nums[0], nums[1]) , 공통_helper_함수(nums,
                new Operator[]{operator}));
        }
    }

    @Test
    void 우선순위_다른_연산_2개씩_섞은_test() {
        Integer[] nums = {1, 3, 5};

        for(Operator first: Operator.values()) {
            for(Operator second: Operator.values()) {
                if(first.equals(second)) {
                    continue;
                }
                Assertions.assertEquals(second.apply(first.apply(nums[0], nums[1]), nums[2]),
                    공통_helper_함수(nums, new Operator[]{first, second}));
            }
        }
    }

}
