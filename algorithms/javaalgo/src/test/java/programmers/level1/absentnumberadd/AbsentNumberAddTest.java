package programmers.level1.absentnumberadd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class AbsentNumberAddTest {

    @Test
    void test() {
        int[] numbers1 = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] numbers2 = {5, 8, 4, 0, 6, 7, 9};

        assertAll(
            () -> assertThat(solution(numbers1)).isEqualTo(14),
            () -> assertThat(solution(numbers2)).isEqualTo(6)
        );
    }

    public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> sets = new HashSet<>();
        for (int number : numbers) {
            sets.add(number);
        }
        for (int i = 0; i < 10; i++) {
            if (!sets.contains(i)) {
                answer += i;
            }
        }
        return answer;
    }
}
