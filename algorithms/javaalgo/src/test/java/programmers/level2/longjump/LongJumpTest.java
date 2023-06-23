package programmers.level2.longjump;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class LongJumpTest {

    static long[] dp;

    @Test
    void test() {
        int n1 = 4;
        int n2 = 3;

        assertAll(
            () -> assertThat(solution(n1)).isEqualTo(5),
            () -> assertThat(solution(n2)).isEqualTo(3)
        );
    }

    public long solution(int n) {
        dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < 2001; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        return dp[n];
    }
}
