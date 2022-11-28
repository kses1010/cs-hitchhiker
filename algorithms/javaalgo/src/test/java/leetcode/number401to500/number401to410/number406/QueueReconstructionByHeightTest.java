package leetcode.number401to500.number401to410.number406;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class QueueReconstructionByHeightTest {

    @Test
    void test() {
        int[][] peoples = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        assertThat(reconstructQueue(peoples)).isEqualTo(new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}});
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ordered = new LinkedList<>();
        for (int[] p : people) {
            ordered.add(p[1], p);
        }

        return ordered.toArray(new int[people.length][2]);
    }
}
