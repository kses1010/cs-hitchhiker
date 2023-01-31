package leetcode.number101to200.number111to120.number118;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PascalsTriangleTest {

    @Test
    void test() {
        assertThat(generate(5)).isEqualTo(List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1),
                List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1)
            )
        );
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answers = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int a = answers.get(i - 1).get(j - 1);
                    int b = answers.get(i - 1).get(j);
                    row.add(a + b);
                }
            }
            answers.add(row);
        }
        return answers;
    }
}
