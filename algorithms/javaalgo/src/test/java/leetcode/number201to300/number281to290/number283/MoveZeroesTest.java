package leetcode.number201to300.number281to290.number283;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MoveZeroesTest {

    @Test
    void test() {
        int[] nums = {0, 1, 0, 3, 12};

        assertThat(moveZeroes(nums)).isEqualTo(new int[]{1, 3, 12, 0, 0});
    }

    public int[] moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        return nums;
    }
}
