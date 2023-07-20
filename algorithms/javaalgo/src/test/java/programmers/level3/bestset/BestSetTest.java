package programmers.level3.bestset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class BestSetTest {

    @Test
    void test() {
        assertAll(
            () -> assertThat(solution(2, 9)).isEqualTo(new int[]{4, 5}),
            () -> assertThat(solution(2, 1)).isEqualTo(new int[]{-1}),
            () -> assertThat(solution(2, 8)).isEqualTo(new int[]{4, 4})
        );
    }

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int num = s / n;
        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }
        int rest = s % n;
        for (int i = 0; i < rest; i++) {
            answer[i]++;
        }

        return reverseOrder(answer);
    }

    public int[] reverseOrder(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
        return numbers;
    }
}
