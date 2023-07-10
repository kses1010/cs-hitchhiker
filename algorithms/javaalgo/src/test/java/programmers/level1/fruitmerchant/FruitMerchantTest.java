package programmers.level1.fruitmerchant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class FruitMerchantTest {

    @Test
    void test() {
        int k1 = 3;
        int m1 = 4;
        int[] score1 = {1, 2, 3, 1, 2, 3, 1};

        int k2 = 4;
        int m2 = 3;
        int[] score2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        assertAll(
            () -> assertThat(solution(k1, m1, score1)).isEqualTo(8),
            () -> assertThat(solution(k2, m2, score2)).isEqualTo(33)
        );
    }

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] boxedScore = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedScore, Collections.reverseOrder());
        int count = 0;
        for (Integer appleScore : boxedScore) {
            count++;
            if (count == m) {
                int minPrice = appleScore;
                answer += minPrice * m;
                count = 0;
            }
        }

        return answer;
    }
}
