package leetcode.number201to300.number201to210.number205;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class IsomorphicStringsTest {

    @Test
    void test() {
        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

        String s3 = "paper";
        String t3 = "title";

        assertAll(
            () -> assertThat(isIsomorphic(s1, t1)).isTrue(),
            () -> assertThat(isIsomorphic(s2, t2)).isFalse(),
            () -> assertThat(isIsomorphic(s3, t3)).isTrue()
        );
    }

    @Test
    void test2() {
        assertThat(isIsomorphic("ab", "aa")).isFalse();
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            int sIndex = sMap.getOrDefault(sChar, -1);
            int tIndex = tMap.getOrDefault(tChar, -1);

            if (sIndex != tIndex) {
                return false;
            }
            sMap.put(sChar, i);
            tMap.put(tChar, i);
        }

        return true;
    }
}
