package leetcode.number501to600.number561to570.number561;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ArrayPartitionTest {

    @Test
    void test() {
        int[] nums1 = {1, 4, 3, 2};
        int[] nums2 = {6, 2, 6, 5, 1, 2};

        assertThat(arrayPairSum(nums1)).isEqualTo(4);
        assertThat(arrayPairSum(nums2)).isEqualTo(9);
    }

    public int arrayPairSum(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                answer += nums[i];
            }
        }
        return answer;
    }
}
