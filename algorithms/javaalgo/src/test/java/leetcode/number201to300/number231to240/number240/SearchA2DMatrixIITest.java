package leetcode.number201to300.number231to240.number240;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SearchA2DMatrixIITest {

    @Test
    void test() {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 5;

        assertThat(searchMatrix(matrix, target)).isTrue();
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;

        while (x <= matrix.length - 1 && y >= 0) {
            if (target == matrix[x][y]) {
                return true;
            } else if (target < matrix[x][y]) {
                y--;
            } else if (target > matrix[x][y]) {
                x++;
            }
        }
        return false;
    }
}
