package programmers.level2.expectedbracket;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ExpectedBracketTest {

    @Test
    void test() {
        int N = 8;
        int A = 4;
        int B = 7;

        assertThat(solution(N, A, B)).isEqualTo(3);
    }

    public int solution(int n, int a, int b) {
        int answer = 1;
        while (n != 2) {
            if (a % 2 != 0) {
                a++;
            }
            if (b % 2 != 0) {
                b++;
            }
            if (a == b) {
                return answer;
            }
            answer++;
            a /= 2;
            b /= 2;
            n /= 2;
        }
        return answer;
    }
}
