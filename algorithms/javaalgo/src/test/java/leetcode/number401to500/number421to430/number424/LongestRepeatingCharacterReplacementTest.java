package leetcode.number401to500.number421to430.number424;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LongestRepeatingCharacterReplacementTest {

    @Test
    void test() {
        String s1 = "ABAB";
        int k1 = 2;
        String s2 = "AABABBA";
        int k2 = 1;
        String s3 = "AAABBC";
        int k3 = 2;

        assertAll(
            () -> assertThat(characterReplacement(s1, k1)).isEqualTo(4),
            () -> assertThat(characterReplacement(s2, k2)).isEqualTo(4),
            () -> assertThat(characterReplacement(s3, k3)).isEqualTo(5)
        );

    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int maxRepeatCount = 0;
        int maxWindow = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            maxRepeatCount = Math.max(maxRepeatCount, charMap.get(c));
            int currentWindow = right - left + 1;

            if (currentWindow - maxRepeatCount > k) {
                char charLeft = s.charAt(left);
                charMap.put(charLeft, charMap.get(charLeft) - 1);
                left++;

                currentWindow = right - left + 1;
            }
            maxWindow = Math.max(maxWindow, currentWindow);
        }
        return maxWindow;
    }
}
