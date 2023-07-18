package programmers.level2.targetnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class TargetNumberTest {

    static int answer;

    @Test
    void test() {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;

        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;

        assertAll(
            () -> assertThat(solution(numbers1, target1)).isEqualTo(5),
            () -> assertThat(solution(numbers2, target2)).isEqualTo(2)
        );
    }

    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(0, numbers, target);

        return answer;
    }

    public void dfs(int L, int[] numbers, int target) {
        if (L == numbers.length) {
            if (target == 0) {
                answer++;
            }
        } else {
            int number = numbers[L];
            dfs(L + 1, numbers, target + number);
            dfs(L + 1, numbers, target - number);
        }
    }
}
