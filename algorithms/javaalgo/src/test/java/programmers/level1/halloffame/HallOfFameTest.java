package programmers.level1.halloffame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class HallOfFameTest {

    @Test
    void test() {
        int k1 = 3;
        int[] score1 = {10, 100, 20, 150, 1, 100, 200};

        int k2 = 4;
        int[] score2 = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        assertAll(
            () -> assertThat(solution(k1, score1)).isEqualTo(new int[]{10, 10, 10, 20, 20, 100, 100}),
            () -> assertThat(solution(k2, score2)).isEqualTo(new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300})
        );
    }

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);

            if (pq.size() > k) {
                pq.poll();
            }
            answer[i] = pq.peek();
        }

        return answer;
    }
}
