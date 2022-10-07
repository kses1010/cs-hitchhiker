package leetcode.number1to100.number31to40.number39;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CombinationSumTest {

    @Test
    void test() {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;

        Solution sol1 = new Solution();
        Solution sol2 = new Solution();

        assertAll(
            () -> assertThat(sol1.combinationSum(candidates1, target1)).isEqualTo(List.of(
                List.of(2, 2, 3),
                List.of(7)
            )),
            () -> assertThat(sol2.combinationSum(candidates2, target2)).isEqualTo(List.of(
                List.of(2, 2, 2, 2),
                List.of(2, 3, 3),
                List.of(3, 5)
            ))
        );

    }
}
