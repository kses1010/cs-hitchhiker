package leetcode.number1to100.number51to60.number53;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MaximumSubarrayTest {

    @Test
    void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        assertThat(maxSubArray(nums)).isEqualTo(6);
    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
