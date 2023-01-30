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
        String minStr = strs[0];
        String maxStr = strs[strs.length - 1];
        int i = 0;
        while (i < minStr.length()) {
            if (minStr.charAt(i) == maxStr.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        if (i == 0) {
            return "";
        }
        return minStr.substring(0, i);
    }
}
