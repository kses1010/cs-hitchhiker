package leetcode.number301to400.number341to350.number347;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class TopKFrequentElementsTest {

    @Test
    void test() {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;

        assertThat(topKFrequent(nums1, k1)).isEqualTo(new int[]{1, 2});
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num : nums) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> maps.get(b) - maps.get(a));
        heap.addAll(maps.keySet());

        int[] answers = new int[k];
        for (int i = 0; i < k; i++) {
            answers[i] = heap.poll();
        }

        return answers;
    }
}
