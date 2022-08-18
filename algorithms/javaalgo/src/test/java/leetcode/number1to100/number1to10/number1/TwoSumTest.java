package leetcode.number1to100.number1to10.number1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

// 1.Two Sum
public class TwoSumTest {

  private static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        return new int[]{map.get(diff), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

  @Test
  void test() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;

    assertThat(twoSum(nums, target)).isEqualTo(new int[]{0, 1});
  }
}
