package programmers.level2.process;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class Print {

    int priority;
    int location;

    public Print(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

public class ProcessTest {

    @Test
    void test() {
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        assertAll(
            () -> assertThat(solution(priorities1, location1)).isEqualTo(1),
            () -> assertThat(solution(priorities2, location2)).isEqualTo(5)
        );
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max = 0;
        Deque<Print> deque = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            max = Math.max(priorities[i], max);
            deque.addLast(new Print(priorities[i], i));
        }
        while (!deque.isEmpty()) {
            Print print = deque.pollFirst();
            if (!deque.isEmpty() && print.priority < max) {
                deque.addLast(print);
            } else {
                answer++;
                max = maxPriority(deque);
                if (print.location == location) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public int maxPriority(Deque<Print> prints) {
        int max = 0;
        for (Print print : prints) {
            max = Math.max(max, print.priority);
        }
        return max;
    }
}
