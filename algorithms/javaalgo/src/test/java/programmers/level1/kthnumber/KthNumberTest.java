package programmers.level1.kthnumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class KthNumberTest {

    @Test
    void test() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
            {2, 5, 3},
            {4, 4, 1},
            {1, 7, 3}
        };

        assertThat(solution(array, commands)).isEqualTo(new int[]{5, 6, 3});
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int start = command[0] - 1;
            int end = command[1];
            int k = command[2] - 1;
            int[] cutArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(cutArray);
            answer[i] = cutArray[k];
        }

        return answer;
    }
}
