package leetcode.number201to300.number231to240;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class ProductOfArrayExceptSelfTest {

    @Test
    void test() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};

        assertAll(
            () -> assertThat(productExceptSelf(nums1)).isEqualTo(new int[]{24, 12, 8, 6}),
            () -> assertThat(productExceptSelf(nums2)).isEqualTo(new int[]{0, 0, 9, 0, 0})
        );
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        int p = 1;
        for (int i = 0; i < length; i++) {
            answer[i] = p;
            p *= nums[i];
        }
        p = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] *= p;
            p *= nums[i];
        }
        return answer;
    }
}
