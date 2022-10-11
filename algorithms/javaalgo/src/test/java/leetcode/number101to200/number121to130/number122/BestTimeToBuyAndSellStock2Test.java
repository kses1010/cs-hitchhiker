package leetcode.number101to200.number121to130.number122;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BestTimeToBuyAndSellStock2Test {

    @Test
    void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};

        assertThat(maxProfit(prices)).isEqualTo(7);
    }

    public int maxProfit(int[] prices) {
        int answer = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                answer += prices[i + 1] - prices[i];
            }
        }
        return answer;
    }
}
