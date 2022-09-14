package leetcode.number1to100.number11to20.number20;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ValidParenthesesTest {

    @Test
    void test() {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";

        assertAll(
            () -> assertThat(isValid(s1)).isTrue(),
            () -> assertThat(isValid(s2)).isTrue(),
            () -> assertThat(isValid(s3)).isFalse()
        );
    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');

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
