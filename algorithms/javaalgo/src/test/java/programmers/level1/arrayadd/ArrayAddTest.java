package programmers.level1.arrayadd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ArrayAddTest {

    @Test
    void test() {
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {5, 6}};

        assertThat(solution(arr1, arr2)).isEqualTo(new int[][]{{4, 6}, {7, 9}});
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int xLength = arr1.length;
        int yLength = arr1[0].length;
        int[][] answer = new int[xLength][yLength];
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
