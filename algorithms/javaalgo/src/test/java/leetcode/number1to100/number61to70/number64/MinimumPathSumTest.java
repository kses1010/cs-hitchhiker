package leetcode.number1to100.number61to70.number64;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MinimumPathSumTest {

    @Test
    void test() {
        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};

        assertThat(minPathSum(grid1)).isEqualTo(7);
        assertThat(minPathSum(grid2)).isEqualTo(12);
    }

    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        int[][] dp = new int[x][y];
        dp[0][0] = grid[0][0];

        // 맨 좌 세로축
        for (int i = 1; i < x; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 맨 상단 가로축
        for (int i = 1; i < y; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[x - 1][y - 1];
    }
}
