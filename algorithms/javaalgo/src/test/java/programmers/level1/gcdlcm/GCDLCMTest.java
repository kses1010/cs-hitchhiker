package programmers.level1.gcdlcm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class GCDLCMTest {

    @Test
    void test() {
        int n1 = 3;
        int n2 = 2;

        int m1 = 12;
        int m2 = 5;

        assertAll(
            () -> assertThat(solution(n1, m1)).isEqualTo(new int[]{3, 12}),
            () -> assertThat(solution(n2, m2)).isEqualTo(new int[]{1, 10})
        );
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = gcd(n, m);
        answer[0] = gcd;

        int lcm = (n * m) / gcd;
        answer[1] = lcm;
        return answer;
    }

    public int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }

        return gcd(num2, num1 % num2);
    }
}
