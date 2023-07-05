package programmers.level2.arraydivide;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ArrayDivideTest {

    @Test
    void test() {
        int n1 = 3;
        int left1 = 2;
        int right1 = 5;

        int n2 = 4;
        int left2 = 7;
        int right2 = 14;

        assertAll(
            () -> assertThat(solution(n1, left1, right1)).isEqualTo(new int[]{3, 2, 2, 3}),
            () -> assertThat(solution(n2, left2, right2)).isEqualTo(new int[]{4, 3, 3, 3, 4, 4, 4, 4})
        );
    }

    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        for (long i = left; i < right + 1; i++) {
            long row = i / n;
            long col = i % n;
            list.add((int) Math.max(row, col) + 1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
