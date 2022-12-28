package leetcode.number1to100.number51to60.number54;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SpiralMatrixTest {

    @Test
    void test() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        assertThat(spiralOrder(matrix)).isEqualTo(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answers = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return answers;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;

        int totalSize = n * m;
        while (answers.size() < totalSize) {
            // 1, 2, 3
            for (int i = left; i <= right && answers.size() < totalSize; i++) {
                answers.add(matrix[up][i]);
            }
            // 6
            for (int i = up + 1; i <= down - 1 && answers.size() < totalSize; i++) {
                answers.add(matrix[i][right]);
            }
            // 9, 8, 7
            for (int i = right; i >= left && answers.size() < totalSize; i--) {
                answers.add(matrix[down][i]);
            }
            // 4
            for (int i = down - 1; i >= up + 1 && answers.size() < totalSize; i--) {
                answers.add(matrix[i][left]);
            }

            left++;
            right--;
            up++;
            down--;
        }
        return answers;
    }
}
