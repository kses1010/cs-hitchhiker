package programmers.level3.overtimeindex;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class OvertimeIndexTest {

    @Test
    void test() {
        int n1 = 4;
        int[] works1 = {4, 3, 3};

        int n2 = 1;
        int[] works2 = {2, 1, 2};

        int n3 = 3;
        int[] works3 = {1, 1};

        assertAll(
            () -> assertThat(solution(n1, works1)).isEqualTo(12),
            () -> assertThat(solution(n2, works2)).isEqualTo(6),
            () -> assertThat(solution(n3, works3)).isEqualTo(0)
        );
    }

    public long solution(int n, int[] works) {
        long answer = 0;
        int sum = 0;
        for (int work : works) {
            sum += work;
        }
        if (sum < n) {
            return answer;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }

        while (n != 0) {
            int maximum = pq.poll();
            if (maximum == 0) {
                break;
            }
            pq.add(maximum - 1);
            n--;
        }

        for (int fatigue : pq) {
            answer += Math.pow(fatigue, 2);
        }
        return answer;
    }
}

