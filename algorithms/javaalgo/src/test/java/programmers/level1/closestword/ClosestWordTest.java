package programmers.level1.closestword;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ClosestWordTest {

    @Test
    void test() {
        String s1 = "banana";
        String s2 = "foobar";

        assertAll(
            () -> assertThat(solution(s1)).isEqualTo(new int[]{-1, -1, -1, 2, 2, 2}),
            () -> assertThat(solution(s2)).isEqualTo(new int[]{-1, -1, 1, -1, -1, -1})
        );
    }

    public int[] solution(String s) {
        int length = s.length();
        int[] answer = new int[length];
        Map<Character, Integer> maps = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (maps.get(c) == null) {
                answer[i] = -1;
            } else {
                answer[i] = i - maps.get(c);
            }
            maps.put(c, i);
        }
        return answer;
    }
}
