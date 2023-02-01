package programmers.level2.numberchange;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class NumberChangeTest {

    @Test
    void test() {
        assertAll(
            () -> assertThat(solution(10, 40, 5)).isEqualTo(2),
            () -> assertThat(solution(10, 40, 30)).isEqualTo(1),
            () -> assertThat(solution(2, 5, 4)).isEqualTo(-1)
        );
    }

    public int solution(int x, int y, int n) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> sets = new HashSet<>();
        q.offer(x);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (q.peek() == y) {
                    return count;
                }
                calculate(q.poll(), y, n, q, sets);
            }
            count++;
        }
        return -1;
    }

    private void calculate(int num, int y, int n, Queue<Integer> q, Set<Integer> sets) {
        if (num + n <= y && !sets.contains(num + n)) {
            q.offer(num + n);
            sets.add(num + n);
        }
        if (num * 2 <= y && !sets.contains(num * 2)) {
            q.offer(num * 2);
            sets.add(num * 2);
        }
        if (num * 3 <= y && !sets.contains(num * 3)) {
            q.offer(num * 3);
            sets.add(num * 3);
        }
    }
}
