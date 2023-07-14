package programmers.level2.newscluster;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NewsClusterTest {

    @Test
    void test() {
        String str1 = "FRANCE";
        String str2 = "french";

        String str3 = "handshake";
        String str4 = "shake hands";

        String str5 = "aa1+aa2";
        String str6 = "AAAA12";

        String str7 = "E=M*C^2";
        String str8 = "e=m*c^2";

        assertAll(
            () -> assertThat(solution(str1, str2)).isEqualTo(16384),
            () -> assertThat(solution(str3, str4)).isEqualTo(65536),
            () -> assertThat(solution(str5, str6)).isEqualTo(43690),
            () -> assertThat(solution(str7, str8)).isEqualTo(65536)
        );
    }

    public int solution(String str1, String str2) {
        List<String> strList1 = makeWord(str1);
        List<String> strList2 = makeWord(str2);

        Collections.sort(strList1);
        Collections.sort(strList2);

        List<String> strAll = new ArrayList<>();
        int duplicateCount = 0;
        for (String s : strList1) {
            if (strList2.contains(s)) {
                duplicateCount++;
                strList2.remove(s);
            }
            strAll.add(s);
        }
        strAll.addAll(strList2);
        if (strAll.isEmpty()) {
            return 65536;
        }

        double jacquardNumber = (double) duplicateCount / (double) strAll.size();

        return (int) (jacquardNumber * 65536);
    }

    public List<String> makeWord(String str) {
        List<String> lists = new ArrayList<>();
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            char firstChar = str.charAt(i);
            char secondChar = str.charAt(i + 1);
            if (Character.isAlphabetic(firstChar) && Character.isAlphabetic(secondChar)) {
                String word = Character.toString(firstChar) + secondChar;
                lists.add(word);
            }

        }
        return lists;
    }
}
