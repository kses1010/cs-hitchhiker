package programmers.level2.carpet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class CarpetTest {

    @Test
    void test() {
        assertAll(
            () -> assertThat(solution(10, 2)).isEqualTo(new int[]{4, 3}),
            () -> assertThat(solution(8, 1)).isEqualTo(new int[]{3, 3}),
            () -> assertThat(solution(24, 24)).isEqualTo(new int[]{8, 6})
        );
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for (int i = 3; i < sum; i++) {
            int j = sum / i;

            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int mid = (col - 2) * (row - 2);

                if (mid == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}
