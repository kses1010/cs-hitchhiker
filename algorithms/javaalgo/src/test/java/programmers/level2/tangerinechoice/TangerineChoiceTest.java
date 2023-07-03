package programmers.level2.tangerinechoice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TangerineChoiceTest {

    @Test
    void test() {
        int k1 = 6;
        int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};

        int k2 = 4;
        int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};

        int k3 = 2;
        int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};

        assertAll(
            () -> assertThat(solution(k1, tangerine1)).isEqualTo(3),
            () -> assertThat(solution(k2, tangerine2)).isEqualTo(2),
            () -> assertThat(solution(k3, tangerine3)).isEqualTo(1)
        );
    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i : tangerine) {
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }
        List<Integer> counts = new ArrayList<>(maps.values());
        counts.sort(Collections.reverseOrder());

        for (int count : counts) {
            if (k > 0) {
                k -= count;
                answer++;
            } else {
                return answer;
            }
        }

        return answer;
    }
}
