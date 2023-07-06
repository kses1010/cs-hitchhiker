package programmers.level1.phoneketmon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class PhoneKetMonTest {

    @Test
    void test() {
        int[] nums1 = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};

        assertAll(
            () -> assertThat(solution(nums1)).isEqualTo(2),
            () -> assertThat(solution(nums2)).isEqualTo(3),
            () -> assertThat(solution(nums3)).isEqualTo(2)
        );
    }

    public int solution(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        int count = nums.length / 2;
        for (int num : nums) {
            sets.add(num);
        }

        int kindCount = sets.size();
        return Math.min(count, kindCount);
    }
}
