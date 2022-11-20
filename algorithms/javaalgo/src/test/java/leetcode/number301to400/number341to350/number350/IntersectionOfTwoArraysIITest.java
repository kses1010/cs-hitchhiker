package leetcode.number301to400.number341to350.number350;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class IntersectionOfTwoArraysIITest {

    @Test
    void test() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};

        assertAll(
            () -> assertThat(intersect(nums1, nums2)).isEqualTo(new int[]{2, 2}),
            () -> assertThat(intersect(nums3, nums4)).isEqualTo(new int[]{4, 9})
        );
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> numbers = new ArrayList<>();

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                numbers.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            }
        }
        int[] answers = new int[numbers.size()];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = numbers.get(i);
        }
        return answers;
    }
}
