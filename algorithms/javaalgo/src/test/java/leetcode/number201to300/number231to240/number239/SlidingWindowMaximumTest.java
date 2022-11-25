package leetcode.number201to300.number231to240.number239;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class SlidingWindowMaximumTest {

    @Test
    void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        assertThat(maxSlidingWindow(nums, k)).isEqualTo(new int[]{3, 3, 5, 5, 6, 7});
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int length = nums.length;
        int[] result = new int[length - k + 1];
        int start = 0;

        Deque<Integer> indexQ = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (!indexQ.isEmpty() && indexQ.peekFirst() < i - k + 1) {
                indexQ.pollFirst();
            }
            while (!indexQ.isEmpty() && nums[indexQ.peekLast()] < nums[i]) {
                indexQ.pollLast();
            }
            indexQ.offer(i);
            if (i >= k - 1) {
                result[start] = nums[indexQ.peekFirst()];
                start++;
            }
        }
        return result;
    }
}
