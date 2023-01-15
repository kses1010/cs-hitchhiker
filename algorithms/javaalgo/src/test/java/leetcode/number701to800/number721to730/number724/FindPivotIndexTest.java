package leetcode.number701to800.number721to730.number724;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class FindPivotIndexTest {

    @Test
    void test() {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {2, 1, -1};

        assertAll(
            () -> assertThat(pivotIndex(nums1)).isEqualTo(3),
            () -> assertThat(pivotIndex(nums2)).isEqualTo(-1),
            () -> assertThat(pivotIndex(nums3)).isEqualTo(0)
        );
    }

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
