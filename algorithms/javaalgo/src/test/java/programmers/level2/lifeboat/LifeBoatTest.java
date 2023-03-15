package programmers.level2.lifeboat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LifeBoatTest {

    @Test
    void test() {
        int[] people1 = {70, 50, 80, 50};
        int[] people2 = {70, 80, 50};
        assertAll(
            () -> assertThat(solution(people1, 100)).isEqualTo(3),
            () -> assertThat(solution(people2, 100)).isEqualTo(3)
        );
    }

    public int solution(int[] people, int limit) {
        int answer = people.length;
        Arrays.sort(people);
        int right = people.length - 1;

        for (int left = 0; left < people.length; left++) {
            while (left < right) {
                if (people[left] + people[right] <= limit) {
                    answer--;
                    right--;
                    break;
                } else {
                    right--;
                }
            }
        }
        return answer;
    }
}
