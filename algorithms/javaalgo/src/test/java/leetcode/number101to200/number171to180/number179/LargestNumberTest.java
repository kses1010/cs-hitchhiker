package leetcode.number101to200.number171to180.number179;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

class LargestNumberComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String order1 = o1 + o2;
        String order2 = o2 + o1;

        // 문자열 내림차순([5, 3, 9] -> [9, 5, 3])
        return order2.compareTo(order1);
    }
}

public class LargestNumberTest {

    @Test
    void test() {
        int[] nums1 = {10, 2};
        int[] nums2 = {3, 30, 34, 5, 9};

        assertAll(
            () -> assertThat(largestNumber(nums1)).isEqualTo("210"),
            () -> assertThat(largestNumber(nums2)).isEqualTo("9534330")
        );
    }

    public String largestNumber(int[] nums) {
        String answer = "";
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, new LargestNumberComparator());

        if (strNums[0].equals("0")) {
            return "0";
        }

        for (String s : strNums) {
            answer += s;
        }

        return answer;
    }
}
