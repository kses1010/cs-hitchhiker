package programmers.level2.jumpandteleport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class JumpAndTeleportTest {

    @Test
    void test() {
        int n1 = 5;
        int n2 = 6;
        int n3 = 5000;

        assertAll(
            () -> assertThat(solution(n1)).isEqualTo(2),
            () -> assertThat(solution(n2)).isEqualTo(2),
            () -> assertThat(solution(n3)).isEqualTo(5)
        );
    }

    public int solution(int n) {
        int answer = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                answer++;
            }
        }

        return answer;
    }
}
