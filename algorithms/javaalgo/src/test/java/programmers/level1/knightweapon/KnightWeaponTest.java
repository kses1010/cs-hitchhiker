package programmers.level1.knightweapon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class KnightWeaponTest {

    static int[] knights;

    @Test
    void test() {
        int number1 = 5;
        int limit1 = 3;
        int power1 = 2;

        int number2 = 10;
        int limit2 = 3;
        int power2 = 2;

        assertAll(
            () -> assertThat(solution(number1, limit1, power1)).isEqualTo(10),
            () -> assertThat(solution(number2, limit2, power2)).isEqualTo(21)
        );
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        knights = new int[number + 1];
        // 약수 개수 구하는법(빠르게)
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                knights[j * i]++;
            }
        }
        for (int i = 1; i <= number; i++) {
            if (knights[i] <= limit) {
                answer += knights[i];
            } else {
                answer += power;
            }
        }

        return answer;
    }
}
