package leetcode.number1to100.number71to80.number73;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class SetMatrixZeroesTest {

    @Test
    void test() {
        int[][] matrix1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        int[][] output1 = {
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 1}
        };
        int[][] matrix2 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        int[][] output2 = {
            {0, 0, 0, 0},
            {0, 4, 5, 0},
            {0, 3, 1, 0}
        };

        assertAll(
            () -> assertThat(setZeroes(matrix1)).isEqualTo(output1),
            () -> assertThat(setZeroes(matrix2)).isEqualTo(output2)
        );
    }

    public int[][] setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col0 = false;
        boolean raw0 = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                raw0 = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (raw0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        return matrix;
    }
}
