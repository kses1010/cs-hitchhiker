package leetcode.number901to1000.number971to980.number973;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

class PointComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        return (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]);
    }
}

public class KClosestTest {

    @Test
    void test() {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;

        int[][] output = {{-2, 2}};
        assertThat(kClosest(points, k)).isEqualTo(output);
    }

    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new PointComparator());
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.toArray(new int[0][0]);
    }
}
