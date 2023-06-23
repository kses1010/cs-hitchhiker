package programmers.level2.bracketrotate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BracketRotateTest {

    @Test
    void test() {
        String s1 = "[](){}";
        String s2 = "}]()[{";
        String s3 = "[)(]";
        String s4 = "}}}";

        assertAll(
            () -> assertThat(solution(s1)).isEqualTo(3),
            () -> assertThat(solution(s2)).isEqualTo(2),
            () -> assertThat(solution(s3)).isEqualTo(0),
            () -> assertThat(solution(s4)).isEqualTo(0)
        );
    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String rotateS = leftRotate(s, i);
            if (rightBracket(rotateS)) {
                answer++;
            }
        }

        return answer;
    }

    public String leftRotate(String s, int d) {
        return s.substring(d) + s.substring(0, d);
    }

    public boolean rightBracket(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put('}', '{');
        maps.put(']', '[');

        for (char c : charArray) {
            if (!maps.containsKey(c)) {
                stack.addLast(c);
            } else if (stack.isEmpty() || maps.get(c) != stack.pollLast()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
