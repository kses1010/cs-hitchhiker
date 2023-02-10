package programmers.level2.fibonaccinumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class FibonacciNumberTest {

    static int[] dp;

    @Test
    void test() {
        assertAll(
            () -> assertThat(solution(3)).isEqualTo(2),
            () -> assertThat(solution(5)).isEqualTo(5)
        );
    }

    public int solution(int n) {
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            int sum = dp[i - 2] + dp[i - 1];
            dp[i] = sum % 1234567;
        }
        return dp[n];
    }
}
