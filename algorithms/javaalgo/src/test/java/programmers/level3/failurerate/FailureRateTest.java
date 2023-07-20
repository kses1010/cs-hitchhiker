package programmers.level3.failurerate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Stage {

    int stage;
    float rate;

    public Stage(int stage, float rate) {
        this.stage = stage;
        this.rate = rate;
    }
}

public class FailureRateTest {

    @Test
    void test() {
        int N1 = 5;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};

        int N2 = 4;
        int[] stages2 = {4, 4, 4, 4, 4};

        assertAll(
            () -> assertThat(solution(N1, stages1)).isEqualTo(new int[]{3, 4, 2, 1, 5}),
            () -> assertThat(solution(N2, stages2)).isEqualTo(new int[]{4, 1, 2, 3})
        );
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> list = new ArrayList<>();
        int userCount = stages.length;

        for (int i = 1; i < N + 1; i++) {
            if (userCount != 0) {
                int count = count(stages, i);
                float rate = (float) count / userCount;
                list.add(new Stage(i, rate));
                userCount -= count;
            } else {
                list.add(new Stage(i, 0f));
            }
        }
        list.sort(((o1, o2) -> Float.compare(o2.rate, o1.rate)));

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stage;
        }
        return answer;
    }

    public int count(int[] arr, int target) {
        int count = 0;
        for (int i : arr) {
            if (i == target) {
                count++;
            }
        }
        return count;
    }
}
