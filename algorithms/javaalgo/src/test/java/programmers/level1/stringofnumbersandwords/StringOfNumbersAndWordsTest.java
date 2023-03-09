package programmers.level1.stringofnumbersandwords;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class StringOfNumbersAndWordsTest {

    @Test
    void test() {
        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        assertAll(
            () -> assertThat(solution(s1)).isEqualTo(1478),
            () -> assertThat(solution(s2)).isEqualTo(234567),
            () -> assertThat(solution(s3)).isEqualTo(234567),
            () -> assertThat(solution(s4)).isEqualTo(123)
        );
    }

    @Test
    void test2() {
        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        assertAll(
            () -> assertThat(solution2(s1)).isEqualTo(1478),
            () -> assertThat(solution2(s2)).isEqualTo(234567),
            () -> assertThat(solution2(s3)).isEqualTo(234567),
            () -> assertThat(solution2(s4)).isEqualTo(123)
        );
    }

    public int solution(String s) {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("zero", 0);
        maps.put("one", 1);
        maps.put("two", 2);
        maps.put("three", 3);
        maps.put("four", 4);
        maps.put("five", 5);
        maps.put("six", 6);
        maps.put("seven", 7);
        maps.put("eight", 8);
        maps.put("nine", 9);

        String answerString = "";
        String wordNumber = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                answerString += c;
            } else {
                wordNumber += c;
                if (maps.containsKey(wordNumber)) {
                    Integer number = maps.get(wordNumber);
                    answerString += number;
                    wordNumber = "";
                }
            }
        }
        return Integer.parseInt(answerString);
    }

    public int solution2(String s) {
        String[] alpha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < alpha.length; i++) {
            s = s.replaceAll(alpha[i], digits[i]);
        }

        return Integer.parseInt(s);
    }
}
