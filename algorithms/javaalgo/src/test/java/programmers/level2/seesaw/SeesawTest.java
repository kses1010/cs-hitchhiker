package programmers.level2.seesaw;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class SeesawTest {

    @Test
    void test() {
        int[] weights = {100, 180, 360, 100, 270};
        assertThat(solution(weights)).isEqualTo(4);
    }

    public long solution(int[] weights) {
        // 1, 2, 3, 4
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> maps = new HashMap<>();
        for (int weight : weights) {
            double a1 = weight * 1.0;
            double a2 = (weight * 1.0) / 2.0;
            double a3 = (weight * 2.0) / 3.0;
            double a4 = (weight * 3.0) / 4.0;

            if (maps.containsKey(a1)) {
                answer += maps.get(a1);
            }
            if (maps.containsKey(a2)) {
                answer += maps.get(a2);
            }
            if (maps.containsKey(a3)) {
                answer += maps.get(a3);
            }
            if (maps.containsKey(a4)) {
                answer += maps.get(a4);
            }
            maps.put(weight * 1.0, maps.getOrDefault(weight * 1.0, 0) + 1);
        }

        return answer;
    }
}
