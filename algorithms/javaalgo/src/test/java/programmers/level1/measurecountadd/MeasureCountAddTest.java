package programmers.level1.measurecountadd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class MeasureCountAddTest {

    @Test
    void test() {
        assertAll(
            () -> assertThat(solution(13, 17)).isEqualTo(43),
            () -> assertThat(solution(24, 27)).isEqualTo(52)
        );
    }

    public int solution(int left, int right) {
        int answer = 0;
        while (left <= right) {
            int count = count(left);
            if (count % 2 == 0) {
                answer += left;
            } else {
                answer -= left;
            }
            left++;
        }
        return answer;
    }

    public int count(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }
}
