package leetcode.number121to130.number121;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class BestTimeToBuyAndSellStockTest {

    @Test
    void test() {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {2, 4, 1};

        assertAll(
            () -> assertThat(maxProfit(prices1)).isEqualTo(5),
            () -> assertThat(maxProfit(prices2)).isEqualTo(2)

        );
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
