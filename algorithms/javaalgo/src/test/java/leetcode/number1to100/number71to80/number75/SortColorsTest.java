package leetcode.number1to100.number71to80.number75;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class SortColorsTest {

    @Test
    void test() {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        int[] nums2 = {2, 0, 1};

        assertAll(
            () -> assertThat(sortColors(nums1)).isEqualTo(new int[]{0, 0, 1, 1, 2, 2}),
            () -> assertThat(sortColors(nums2)).isEqualTo(new int[]{0, 1, 2})
        );
    }

    public int[] sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] < 1) {
                swap(nums, red, white);
                red++;
                white++;
            } else if (nums[white] > 1) {
                swap(nums, blue, white);
                blue--;
            } else {
                white++;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
