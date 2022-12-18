package leetcode.number1to100.number31to40.number32;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class LongestValidParenthesesTest {

    @Test
    void test() {
        String s1 = "(()";
        String s2 = ")()())";

        assertAll(
            () -> assertThat(longestValidParentheses(s1)).isEqualTo(2),
            () -> assertThat(longestValidParentheses(s2)).isEqualTo(4)
        );
    }

    public int longestValidParentheses(String s) {
        int answer = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                int validSize = stack.isEmpty() ? i + 1 : i - stack.peek();
                answer = Math.max(answer, validSize);
            } else {
                stack.push(i);
            }
        }
        return answer;
    }

    public int longestValidDp(String s) {
        int answer = 0;
        int[] dp = new int[s.length()];
        int leftCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                answer = Math.max(answer, dp[i]);
                leftCount--;
            }
        }
        return answer;
    }
}
