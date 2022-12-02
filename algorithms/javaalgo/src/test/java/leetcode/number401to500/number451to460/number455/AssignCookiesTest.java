package leetcode.number401to500.number451to460.number455;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class AssignCookiesTest {

    @Test
    void test() {
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};

        assertThat(findContentChildren(g1, s1)).isEqualTo(1);
        assertThat(findContentChildren(g2, s2)).isEqualTo(2);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;
        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++;
            }
            cookieIndex++;
        }
        return childIndex;
    }
}
