package leetcode.number201to300.number241to250.number242;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ValidAnagramTest {

    @Test
    void test() {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        assertAll(
            () -> assertThat(isAnagram(s1, t1)).isTrue(),
            () -> assertThat(isAnagram(s2, t2)).isFalse()
        );
    }

    public boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        if (charS.length != charT.length) {
            return false;
        }

        Arrays.sort(charS);
        Arrays.sort(charT);

        for (int i = 0; i < charS.length; i++) {
            if (charS[i] != charT[i]) {
                return false;
            }
        }

        return true;
    }
}
