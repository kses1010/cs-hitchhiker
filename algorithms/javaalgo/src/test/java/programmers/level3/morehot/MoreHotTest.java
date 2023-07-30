package programmers.level3.morehot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class MoreHotTest {

    @Test
    void test() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        assertThat(solution(scoville, k)).isEqualTo(2);
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int hot : scoville) {
            pq.add(hot);
        }

        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int newFood = first + (second * 2);
            pq.add(newFood);
            answer++;
        }
        if (pq.peek() < K) {
            return -1;
        }
        return answer;
    }
}
