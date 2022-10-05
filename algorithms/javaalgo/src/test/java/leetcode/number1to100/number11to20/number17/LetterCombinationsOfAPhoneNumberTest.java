package leetcode.number1to100.number11to20.number17;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LetterCombinationsOfAPhoneNumberTest {

    private static Map<Integer, String> maps = new HashMap<>();

    @Test
    void test() {
        String digits = "23";

        assertThat(letterCombinations(digits)).isEqualTo(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> answers = new ArrayList<>();

        if (digits.length() == 0) {
            return answers;
        }

        maps.put(2, "abc");
        maps.put(3, "def");
        maps.put(4, "ghi");
        maps.put(5, "jkl");
        maps.put(6, "mno");
        maps.put(7, "pqrs");
        maps.put(8, "tuv");
        maps.put(9, "wxyz");

        dfs(answers, digits.toCharArray(), "");
        return answers;
    }

    private void dfs(List<String> answers, char[] digits, String s) {
        int length = s.length();
        // 끝까지 탐색하면 백트래킹
        if (length == digits.length) {
            answers.add(s);
            return;
        }

        int digit = digits[length] - '0';
        for (char letter : maps.get(digit).toCharArray()) {
            dfs(answers, digits, s + letter);
        }
    }
}
