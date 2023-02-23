package programmers.level1.sortyourownstrings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SortYourOwnStringsTest {

    @Test
    void test() {
        String[] strings1 = {"sun", "bed", "car"};
        String[] strings2 = {"abce", "abcd", "cdx"};

        assertAll(
            () -> assertThat(solution(strings1, 1)).isEqualTo(new String[]{"car", "bed", "sun"}),
            () -> assertThat(solution(strings2, 2)).isEqualTo(new String[]{"abcd", "abce", "cdx"})
        );
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> list = new ArrayList<>();
        for (String s : strings) {
            list.add(s.charAt(n) + s);
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            String string = list.get(i);
            answer[i] = string.substring(1);
        }
        return answer;
    }
}
