package leetcode.number1to100.number41to50.number45;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class JumpGame2Test {

    @Test
    void test() {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};

        assertAll(
            () -> assertThat(jump(nums1)).isEqualTo(2),
            () -> assertThat(jump(nums2)).isEqualTo(2)
        );
    }

    public int jump(int[] nums) {
        int destination = nums.length - 1;
        int stepCount = 0;
        int lastJumpMax = 0;
        int currentJumpMax = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currentJumpMax = Math.max(currentJumpMax, i + nums[i]);
            if (i == lastJumpMax) {
                stepCount++;
                lastJumpMax = currentJumpMax;
                if (currentJumpMax >= destination) {
                    return stepCount;
                }
            }
        }
        return stepCount;
    }
}
