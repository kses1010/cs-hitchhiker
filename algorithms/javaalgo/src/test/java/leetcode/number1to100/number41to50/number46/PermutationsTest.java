package leetcode.number1to100.number41to50.number46;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PermutationsTest {

    @Test
    void test() {
        int[] nums = {1, 2, 3};
        Solution sol = new Solution();

        assertThat(sol.permute(nums)).isEqualTo(List.of(
            List.of(1, 2, 3),
            List.of(1, 3, 2),
            List.of(2, 1, 3),
            List.of(2, 3, 1),
            List.of(3, 1, 2),
            List.of(3, 2, 1)
        ));
    }
}
