package leetcode.number1to100.number51to60.number55;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class JumpGameTest {

    @Test
    void test() {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        assertThat(canJump(nums1)).isTrue();
        assertThat(canJump(nums2)).isFalse();
    }

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int lastJump = 0;

        for (int i = 0; i < length; i++) {
            if (i > lastJump) {
                return false;
            }
            lastJump = Math.max(lastJump, i + nums[i]);
        }
        return true;
    }
}
