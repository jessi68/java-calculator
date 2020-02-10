package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class StringTest {
    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        Assertions.assertThat(result).contains("1");
        Assertions.assertThat(result).contains("2");
        String[] temp = {"1", "2"};
        Assertions.assertThat(result).containsExactly(temp);
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        Assertions.assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("charAt method out of bounds test")
    void charAtTest() {
        String value = "abc";
        Assertions.assertThatThrownBy(() -> {
            value.charAt(10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range");
    }
}
