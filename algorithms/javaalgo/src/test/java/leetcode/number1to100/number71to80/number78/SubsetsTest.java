package leetcode.number1to100.number71to80.number78;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class SubsetsTest {

    @Test
    void test() {
        int[] nums = {1, 2, 3};

        Solution sol = new Solution();
        assertThat(sol.subsets(nums)).containsAnyElementsOf(List.of(
            List.of(),
            List.of(1),
            List.of(2),
            List.of(3),
            List.of(1, 2),
            List.of(1, 3),
            List.of(2, 3),
            List.of(1, 2, 3)
        ));
    }
}
