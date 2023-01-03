package leetcode.number1to100.number61to70.number62;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class UniquePathsTest {

    @Test
    void test() {
        assertAll(
            () -> assertThat(uniquePaths(3, 7)).isEqualTo(28),
            () -> assertThat(uniquePaths(3, 2)).isEqualTo(3)
        );
    }

    public int uniquePaths(int m, int n) {
        int[][] maps = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    maps[i][j] = 1;
                } else {
                    maps[i][j] = maps[i][j - 1] + maps[i - 1][j];
                }
            }
        }
        return maps[m - 1][n - 1];
    }
}
