package leetcode.number1to100.number31to40.number35;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SearchInsertPositionTest {

    @Test
    void test() {
        int[] nums = {1, 3, 5, 6};

        assertThat(searchInsert(nums, 2)).isEqualTo(1);
        assertThat(searchInsert(nums, 7)).isEqualTo(4);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
