package programmers.level3.integertriangle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class IntegerTriangleTest {

    @Test
    void test() {
        int[][] triangle = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        };

        assertThat(solution(triangle)).isEqualTo(30);
    }

    public int solution(int[][] triangle) {
        int answer = 0;
        if (triangle.length == 1) {
            return triangle[0][0];
        }
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (i == j) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }
}
