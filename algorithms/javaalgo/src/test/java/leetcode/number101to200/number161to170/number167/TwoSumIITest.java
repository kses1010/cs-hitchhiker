package leetcode.number101to200.number161to170.number167;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TwoSumIITest {

    @Test
    void test() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] numbers2 = {2, 3, 4};
        int target2 = 6;

        assertThat(twoSum(numbers, target)).isEqualTo(new int[]{1, 2});
        assertThat(twoSum(numbers2, target2)).isEqualTo(new int[]{1, 3});
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            int expect = target - numbers[i];

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] < expect) {
                    left = mid + 1;
                } else if (numbers[mid] > expect) {
                    right = mid - 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return new int[2];
    }
}
