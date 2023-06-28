package programmers.level1.coke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class CokeTest {

    @Test
    void test() {
        int a1 = 2;
        int a2 = 3;
        int b = 1;
        int n = 20;

        assertAll(
            () -> assertThat(solution(a1, b, n)).isEqualTo(19),
            () -> assertThat(solution(a2, b, n)).isEqualTo(9)
        );
    }

    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int change = n / a;
            int coke = change * b;
            answer += coke;
            n = (n - (change * a) + coke);
        }
        return answer;
    }
}
