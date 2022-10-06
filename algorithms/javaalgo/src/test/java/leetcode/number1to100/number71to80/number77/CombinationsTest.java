package leetcode.number1to100.number71to80.number77;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CombinationsTest {

    @Test
    void test() {
        int n = 4;
        int k = 2;
        Solution sol = new Solution();

        assertThat(sol.combine(n, k)).isEqualTo(List.of(
            List.of(1, 2),
            List.of(1, 3),
            List.of(1, 4),
            List.of(2, 3),
            List.of(2, 4),
            List.of(3, 4)
        ));
    }
}
