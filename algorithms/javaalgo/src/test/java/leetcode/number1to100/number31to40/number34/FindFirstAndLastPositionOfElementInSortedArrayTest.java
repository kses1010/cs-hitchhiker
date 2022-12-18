package leetcode.number1to100.number31to40.number34;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};

        assertThat(searchRange(nums, 8)).isEqualTo(new int[]{3, 4});
        assertThat(searchRange(nums, 6)).isEqualTo(new int[]{-1, -1});
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int[] answers = {-1, -1};
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == target && answers[0] == -1) {
                answers[0] = left;
            }
            if (nums[right] == target && answers[1] == -1) {
                answers[1] = right;
            }
            if (nums[left] < target) {
                left++;
            }
            if (nums[right] > target) {
                right--;
            }
            if (answers[0] != -1 && answers[1] != -1) {
                break;
            }
        }
        return answers;
    }
}
