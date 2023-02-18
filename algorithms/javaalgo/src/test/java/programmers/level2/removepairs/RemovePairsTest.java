package programmers.level2.removepairs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class RemovePairsTest {

    @Test
    void test() {
        String s1 = "baabaa";
        String s2 = "cdcd";

        assertAll(
            () -> assertThat(solution(s1)).isEqualTo(1),
            () -> assertThat(solution(s2)).isEqualTo(0)
        );
    }

    public int solution(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == c) {
                stack.pollLast();
            } else {
                stack.addLast(c);
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
