package programmers.level3.doublepriorityqueue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class DoublePriorityQueueTest {

    @Test
    void test() {
        String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        assertAll(
            () -> assertThat(solution(operations1)).isEqualTo(new int[]{0, 0}),
            () -> assertThat(solution(operations2)).isEqualTo(new int[]{333, -45})
        );
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for (String s : operations) {
            String[] operation = s.split(" ");
            String s1 = operation[0];
            int num = Integer.parseInt(operation[1]);
            if (s1.equals("I")) {
                minPq.add(num);
                maxPq.add(num);
            } else {
                if (!minPq.isEmpty() && !maxPq.isEmpty()) {
                    if (num == -1) {
                        int pollNumber = minPq.poll();
                        maxPq.remove(pollNumber);
                    } else {
                        int pollNumber = maxPq.poll();
                        minPq.remove(pollNumber);
                    }
                }
            }
        }
        if (minPq.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxPq.poll(), minPq.poll()};
    }
}
