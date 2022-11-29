package leetcode.number601to700.number621to630.number621;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class TaskSchedulerTest {

    @Test
    void test() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        assertThat(leastInterval(tasks, n)).isEqualTo(8);
    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> maps = new HashMap<>();
        for (char task : tasks) {
            maps.put(task, maps.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(maps.values());

        int maxFreq = pq.poll();
        int totalIdleTime = (maxFreq - 1) * n;

        while (!pq.isEmpty()) {
            int currentFreq = pq.poll();
            if (currentFreq == maxFreq) {
                totalIdleTime -= currentFreq;
                totalIdleTime++;
            } else {
                totalIdleTime -= currentFreq;
            }
        }

        if (totalIdleTime > 0) {
            return totalIdleTime + tasks.length;
        }
        return tasks.length;
    }
}
