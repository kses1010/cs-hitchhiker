package leetcode.number1to100.number11to20.number15;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ThreeSumJavaTest {

    @Test
    void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> answers = List.of(
            List.of(-1, -1, 2), List.of(-1, 0, 1)
        );

        assertThat(threeSum(nums)).isEqualTo(answers);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        Arrays.sort(nums);

        int length = nums.length;
        if (length <= 2) {
            return answers;
        }

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int lt = i + 1;
            int rt = length - 1;

            while (lt < rt) {
                int threeSum = nums[i] + nums[lt] + nums[rt];

                if (threeSum < 0) {
                    lt++;
                } else if (threeSum > 0) {
                    rt--;
                } else {
                    answers.add(List.of(nums[i], nums[lt], nums[rt]));
                    while (lt < rt && nums[lt] == nums[lt + 1]) {
                        lt++;
                    }
                    while (lt < rt && nums[rt] == nums[rt - 1]) {
                        rt--;
                    }
                    lt++;
                    rt--;
                }
            }
        }
        return answers;
    }
}
