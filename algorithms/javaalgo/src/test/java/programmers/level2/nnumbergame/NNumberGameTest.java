package programmers.level2.nnumbergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class NNumberGameTest {

    @Test
    void test() {
        int n1 = 2;
        int t1 = 4;
        int m1 = 2;
        int p1 = 1;

        int n2 = 16;
        int t2 = 16;
        int m2 = 2;
        int p2 = 1;

        int n3 = 16;
        int t3 = 16;
        int m3 = 2;
        int p3 = 2;

        assertAll(
            () -> assertThat(solution(n1, t1, m1, p1)).isEqualTo("0111"),
            () -> assertThat(solution(n2, t2, m2, p2)).isEqualTo("02468ACE11111111"),
            () -> assertThat(solution(n3, t3, m3, p3)).isEqualTo("13579BDF01234567")
        );
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; sb.length() < t * m; i++) {
            sb.append(Integer.toString(i, n).toUpperCase());
        }

        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(sb.charAt(i));
        }

        return answer.toString();
    }
}
