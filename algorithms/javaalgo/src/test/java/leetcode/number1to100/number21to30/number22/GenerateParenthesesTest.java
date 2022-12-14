package leetcode.number1to100.number21to30.number22;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GenerateParenthesesTest {

    List<String> answers = new ArrayList<>();

    @Test
    void test() {
        List<String> output1 = List.of("((()))", "(()())", "(())()", "()(())", "()()()");

        assertThat(generateParenthesis(3)).isEqualTo(output1);
    }

    public List<String> generateParenthesis(int n) {
        dfs("", n, 0);
        return answers;
    }

    public void dfs(String str, int left, int right) {
        if (left == 0 && right == 0) {
            answers.add(str);
            return;
        }

        if (left > 0) {
            dfs(str + "(", left - 1, right + 1);
        }
        if (right > 0) {
            dfs(str + ")", left, right - 1);
        }
    }
}
