package programmers.level1.thethreemusketeers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class TheThreeMusketeersTest {

    static int[] nums;
    static int answer;
    static int length;

    @Test
    void test() {
        int[] numbers1 = {-2, 3, 0, 2, -5};
        int[] numbers2 = {-3, -2, -1, 0, 1, 2, 3};
        int[] numbers3 = {-1, 1, -1, 1};

        assertAll(
            () -> assertThat(solution(numbers1)).isEqualTo(2),
            () -> assertThat(solution(numbers2)).isEqualTo(5),
            () -> assertThat(solution(numbers3)).isEqualTo(0)
        );
    }

    public int solution(int[] numbers) {
        answer = 0;
        nums = new int[3];
        length = numbers.length;

        dfs(numbers, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int index, int L) {
        if (L == 3) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum == 0) {
                answer++;
            }
            return;
        }
        for (int i = index; i < length; i++) {
            nums[L] = numbers[i];
            dfs(numbers, i + 1, L + 1);
        }
    }
}
