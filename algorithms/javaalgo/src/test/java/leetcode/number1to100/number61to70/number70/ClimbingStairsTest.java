package leetcode.number1to100.number61to70.number70;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class ClimbingStairsTest {

    @Test
    void test() {
        assertAll(
            () -> assertThat(climbStairs(2)).isEqualTo(2),
            () -> assertThat(climbStairs(3)).isEqualTo(3),
            () -> assertThat(climbStairs(4)).isEqualTo(5)
        );
    }

    public int climbStairs(int n) {
        int[] dy = new int[n + 1];
        if (n <= 2) {
            return n;
        }
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }
}
