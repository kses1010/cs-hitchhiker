package basic.datastructure.recursive;

import static org.assertj.core.api.Assertions.assertThat;

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
}
