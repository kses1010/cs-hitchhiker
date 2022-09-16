package leetcode.number731to740.number739;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class DailyTemperaturesTest {

    @Test
    void test() {
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {30, 40, 50, 60};

        assertAll(
            () -> assertThat(dailyTemperatures(temperatures1)).isEqualTo(new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
            () -> assertThat(dailyTemperatures(temperatures2)).isEqualTo(new int[]{1, 1, 1, 0})
        );
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] answers = new int[size];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()]) {
                int last = stack.pollLast();
                answers[last] = i - last;
            }
            stack.addLast(i);
        }
        return answers;
    }
}
