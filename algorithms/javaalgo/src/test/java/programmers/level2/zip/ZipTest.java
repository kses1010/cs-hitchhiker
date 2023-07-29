package programmers.level2.zip;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ZipTest {

    static Map<String, Integer> dict;

    @Test
    void test() {
        String msg1 = "KAKAO";
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";

        assertAll(
            () -> assertThat(solution(msg1)).isEqualTo(new int[]{11, 1, 27, 15}),
            () -> assertThat(solution(msg2)).isEqualTo(
                new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}),
            () -> assertThat(solution(msg3)).isEqualTo(
                new int[]{1, 2, 27, 29, 28, 31, 30})
        );

    }

    public int[] solution(String msg) {
        List<Integer> answers = new ArrayList<>();
        dict = new HashMap<>();
        initDict();
        int dictIndex = 27;
        int index = 0;
        int length = msg.length();

        while (index < length) {
            if (index == length - 1) {
                answers.add(dict.get(String.valueOf(msg.charAt(index))));
                break;
            }
            String word = String.valueOf(msg.charAt(index));
            index++;
            while (index < length) {
                String nextWord = String.valueOf(msg.charAt(index));
                if (!dict.containsKey(word + nextWord)) {
                    dict.put(word + nextWord, dictIndex);
                    dictIndex++;
                    break;
                }
                word += nextWord;
                index++;
            }
            answers.add(dict.get(word));
        }
        return answers.stream().mapToInt(i -> i).toArray();
    }

    public void initDict() {
        int index = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            dict.put(String.valueOf((char) i), index++);
        }
    }
}
