package leetcode.number301to400.number391to400.number392;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class IsSubsequenceTest {

    @Test
    void test() {
        String s1 = "ace";
        String s2 = "abc";
        String s3 = "acb";

        String t1 = "abcde";
        String t2 = "ahbgdc";
        assertAll(
            () -> assertThat(isSubsequence(s1, t1)).isTrue(),
            () -> assertThat(isSubsequence(s2, t2)).isTrue(),
            () -> assertThat(isSubsequence(s3, t2)).isFalse()
        );
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (index > s.length() - 1) {
                return true;
            }
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
        }
        return index == s.length();
    }
}
