package leetcode.number1to100.number71to80.number72;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EditDistanceTest {

    @Test
    void test() {
        String word1 = "horse";
        String word2 = "ros";

        assertThat(minDistance(word1, word2)).isEqualTo(3);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j];
                    int delete = dp[i][j + 1];
                    int insert = dp[i + 1][j];
                    dp[i + 1][j + 1] = Math.min(replace, Math.min(delete, insert)) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
