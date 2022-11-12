package codility.naver;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Test;

public class NaverCodility2021Test {

    @Test
    void test1() {
        String S = "LILLYBILLYBOO";
        String[] L = {"BILL", "MARIA", "LILLY"};

        assertThat(nameArray(S, L)).isEqualTo(new int[]{2, 0, 1});
    }

    public int[] nameArray(String S, String[] L) {
        int[] answers = new int[L.length];
        Map<Character, Integer> stringMaps = new HashMap<>();
        // 문자열 맵스
        for (char c : S.toCharArray()) {
            stringMaps.put(c, stringMaps.getOrDefault(c, 0) + 1);
        }

        // 문자 배열 별 확인
        for (int i = 0; i < L.length; i++) {
            String s = L[i];
            // 갯수 체크
            int count = Integer.MAX_VALUE;
            Map<Character, Integer> nameMaps = new HashMap<>();
            for (char c : s.toCharArray()) {
                nameMaps.put(c, nameMaps.getOrDefault(c, 0) + 1);
            }
            for (Entry<Character, Integer> entry : nameMaps.entrySet()) {
                Character key = entry.getKey();
                Integer charCount = stringMaps.get(key);
                // 해당 문자가 없다면 0처리
                if (charCount == null) {
                    answers[i] = 0;
                    break;
                }
                count = Math.min(count, charCount / entry.getValue());
            }
            // 최대값이 아닐 경우만 count 기입
            if (count != Integer.MAX_VALUE) {
                answers[i] = count;
            }
        }
        return answers;
    }
}
