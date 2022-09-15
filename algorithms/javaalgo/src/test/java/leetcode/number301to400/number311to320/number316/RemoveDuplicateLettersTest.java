package leetcode.number301to400.number311to320.number316;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class RemoveDuplicateLettersTest {

    @Test
    void test() {
        String s1 = "bcabc";
        String s2 = "cbacdbc";

        assertAll(
            () -> assertThat(removeDuplicateLetters(s1)).isEqualTo("abc"),
            () -> assertThat(removeDuplicateLetters(s2)).isEqualTo("acdb")
        );
    }

    public String removeDuplicateLetters(String s) {
        // 스택 문자 관리
        Deque<Character> stack = new LinkedList<>();
        // 알파벳 갯수 배열
        int[] count = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            count[c - 'a']++; // 각 알파벳 갯수 세기
        }
        // 알파벳 stack 추가 되어있는지 여부 배열
        boolean[] visited = new boolean[26];
        for (char c : charArray) {
            int alphabetIndex = c - 'a';
            count[alphabetIndex]--;
            // 이미 체크한 알파벳이라면 넘기기
            if (visited[alphabetIndex]) {
                continue;
            }
            // 스택 마지막 알파벳이 기존보다 사전적으로 뒷순위 이면서 뒤에 남은 알파벳이 남아 있는 경우
            while (!stack.isEmpty() && stack.peekLast() > c && count[stack.peekLast() - 'a'] > 0) {
                visited[stack.peekLast() - 'a'] = false;
                stack.pollLast();
            }
            stack.addLast(c);
            visited[alphabetIndex] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
