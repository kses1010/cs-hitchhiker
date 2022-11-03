package basic.datastructure.recursive;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RecursiveTest {

    @Test
    void permTest() {
        int[] nums = {1, 2, 3};
        Permutations perm = new Permutations(nums);

        assertThat(perm.permute()).isEqualTo(List.of(
            List.of(1, 2, 3),
            List.of(1, 3, 2),
            List.of(2, 1, 3),
            List.of(2, 3, 1),
            List.of(3, 1, 2),
            List.of(3, 2, 1)
        ));
    }

    @Test
    void combiTest() {
        Combinations combi = new Combinations(4, 2);

        assertThat(combi.combine()).isEqualTo(List.of(
            List.of(1, 2),
            List.of(1, 3),
            List.of(1, 4),
            List.of(2, 3),
            List.of(2, 4),
            List.of(3, 4)
        ));
    }

    @Test
    void combiSumTest() {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;

        Combinations combiSum1 = new Combinations(candidates1);
        Combinations combiSum2 = new Combinations(candidates2);

        assertAll(
            () -> assertThat(combiSum1.combiSum(target1)).isEqualTo(List.of(
                List.of(2, 2, 3),
                List.of(7)
            )),
            () -> assertThat(combiSum2.combiSum(target2)).isEqualTo(List.of(
                List.of(2, 2, 2, 2),
                List.of(2, 3, 3),
                List.of(3, 5)
            ))
        );
    }
}
