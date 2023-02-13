package leetcode.number1to100.number31to40.number31;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class NextPermutationTest {

    @Test
    void test() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 2, 1};
        int[] nums3 = {1, 1, 5};

        assertAll(
            () -> assertThat(nextPermutation(nums1)).isEqualTo(new int[]{1, 3, 2}),
            () -> assertThat(nextPermutation(nums2)).isEqualTo(new int[]{1, 2, 3}),
            () -> assertThat(nextPermutation(nums3)).isEqualTo(new int[]{1, 5, 1})
        );
    }

    public int[] nextPermutation(int[] nums) {
        int pivot = indexOfLastPeak(nums) - 1;

        if (pivot != -1) {
            int nextPrefix = lastIndexOfGreater(nums, nums[pivot]);
            swap(nums, pivot, nextPrefix);
        }
        reversePivot(nums, pivot + 1);
        return nums;
    }

    private int indexOfLastPeak(int[] nums) {
        int end = nums.length - 1;
        for (int i = end; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }

    private int lastIndexOfGreater(int[] nums, int num) {
        int end = nums.length - 1;
        for (int i = end; i >= 0; i--) {
            if (num < nums[i]) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reversePivot(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
