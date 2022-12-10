package leetcode.number1to100.number1to10.number4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MedianOfTwoSortedArraysTest {

    @Test
    void test() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int[] nums3 = {1, 3};
        int[] nums4 = {2};

        assertThat(findMedianSortedArrays(nums1, nums2)).isEqualTo(2.50000);
        assertThat(findMedianSortedArrays(nums3, nums4)).isEqualTo(2.00000);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;

        int l1 = nums1.length;
        int l2 = nums2.length;

        for (int i = 0; i <= (l1 + l2) / 2; i++) {
            med1 = med2;
            if (index1 == l1) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == l2) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                med2 = nums1[index1];
                index1++;
            } else {
                med2 = nums2[index2];
                index2++;
            }
        }

        // 합친 배열의 길이가 짝수일 경우
        if ((l1 + l2) % 2 == 0) {
            return (double) (med1 + med2) / 2;
        }

        return med2;
    }
}
