package leetcode.number101to200.number161to170.number169;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MajorityElementTest {

    @Test
    void test() {
        int[] nums = {3, 2, 3};
        int output = 3;

        assertThat(majorityElement(nums)).isEqualTo(output);
    }

    public int majorityElement(int[] nums) {
        int majoritySize = nums.length / 2;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int n : nums) {
            maps.put(n, maps.getOrDefault(n, 0) + 1);
            if (maps.get(n) > majoritySize) {
                return n;
            }
        }
        return 0;
    }
}
