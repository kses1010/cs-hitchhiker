package programmers.level2.foodfightcompetition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class FoodFightCompetitionTest {

    @Test
    void test() {
        int[] food1 = {1, 3, 4, 6};
        int[] food2 = {1, 7, 1, 2};

        assertAll(
            () -> assertThat(solution(food1)).isEqualTo("1223330333221"),
            () -> assertThat(solution(food2)).isEqualTo("111303111")
        );
    }

    public String solution(int[] food) {
        String left = "";
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                left += String.valueOf(i);
            }
        }

        String right = "";
        for (int i = left.length() - 1; i >= 0; i--) {
            right += left.charAt(i);
        }

        return left + "0" + right;
    }
}
