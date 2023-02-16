package programmers.level1.minimalrectangle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class MinimalRectangleTest {

    @Test
    void test() {
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        assertAll(
            () -> assertThat(solution(sizes1)).isEqualTo(4000),
            () -> assertThat(solution(sizes2)).isEqualTo(120),
            () -> assertThat(solution(sizes3)).isEqualTo(133)
        );
    }

    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            maxW = Math.max(w, maxW);
            maxH = Math.max(h, maxH);
        }
        return maxW * maxH;
    }
}
