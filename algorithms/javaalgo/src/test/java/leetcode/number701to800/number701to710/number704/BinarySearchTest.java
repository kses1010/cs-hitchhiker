package leetcode.number701to800.number701to710.number704;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    private int[] nums;
    private int target;

    @Test
    void test() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        assertThat(search(nums, target)).isEqualTo(4);
        assertThat(forSearch(nums, target)).isEqualTo(4);
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return dfs(0, nums.length - 1);
    }

    private int dfs(int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < target) {
                return dfs(mid + 1, right);
            } else if (nums[mid] > target) {
                return dfs(left, mid - 1);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }

    public int forSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < target) {
                left++;
            } else if (nums[mid] > target) {
                right--;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
