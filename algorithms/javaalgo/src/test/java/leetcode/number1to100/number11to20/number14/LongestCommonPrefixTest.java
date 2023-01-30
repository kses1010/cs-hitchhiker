package leetcode.number1to100.number11to20.number14;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LongestCommonPrefixTest {

    @Test
    void test() {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};

        assertAll(
            () -> assertThat(longestCommonPrefix(strs1)).isEqualTo("fl"),
            () -> assertThat(longestCommonPrefix(strs2)).isEqualTo("")
        );
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length()) {
            if (first.charAt(i) == last.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        if (i == 0) {
            return "";
        }
        return first.substring(0, i);
    }
}
