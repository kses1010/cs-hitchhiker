package programmers.level1.paintover;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class PaintOverTest {

    @Test
    void test() {
        int n1 = 8;
        int m1 = 4;
        int[] section1 = {2, 3, 6};

        int n2 = 5;
        int m2 = 4;
        int[] section2 = {1, 3};

        int n3 = 4;
        int m3 = 1;
        int[] section3 = {1, 2, 3, 4};

        assertAll(
            () -> assertThat(solution(n1, m1, section1)).isEqualTo(2),
            () -> assertThat(solution(n2, m2, section2)).isEqualTo(1),
            () -> assertThat(solution(n3, m3, section3)).isEqualTo(4)
        );
    }

    public int solution(int n, int m, int[] section) {
        int answer = 1;
        if (n == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;
        while (right < section.length) {
            int range = section[right] - section[left];
            if (range < m) {
                right++;
            } else {
                left = right;
                right = left + 1;
                answer++;
            }
        }
        return answer;
    }
}
