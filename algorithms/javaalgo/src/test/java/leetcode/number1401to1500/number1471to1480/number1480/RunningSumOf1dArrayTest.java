package leetcode.number1401to1500.number1471to1480.number1480;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RunningSumOf1dArrayTest {

    @Test
    void test() {
        int[] nums = {1, 2, 3, 4};
        assertThat(runningSum(nums)).isEqualTo(new int[]{1, 3, 6, 10});
    }

    public int[] runningSum(int[] nums) {
        if (nums.length == 1) {
            return new int[]{nums[0]};
        }
        int[] answer = new int[nums.length];
        answer[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] + nums[i];
        }
        return answer;
    }
}
