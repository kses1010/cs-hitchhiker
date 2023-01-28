package programmers.level2.findthelargestnumberbehind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class FindTheLargestNumberBehindTest {

    @Test
    void test() {
        int[] numbers1 = {2, 3, 3, 5};
        int[] numbers2 = {9, 1, 5, 3, 6, 2};

        assertAll(
            () -> assertThat(solution(numbers1)).isEqualTo(new int[]{3, 5, 5, -1}),
            () -> assertThat(solution(numbers2)).isEqualTo(new int[]{-1, 5, 6, 6, -1, -1})
        );
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peekLast()]) {
                int lastIndex = stack.pollLast();
                answer[lastIndex] = numbers[i];
            }
            stack.addLast(i);
        }

        return answer;
    }
}
