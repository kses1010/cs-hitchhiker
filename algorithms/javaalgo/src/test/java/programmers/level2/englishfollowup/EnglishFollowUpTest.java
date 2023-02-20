package programmers.level2.englishfollowup;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class EnglishFollowUpTest {

    @Test
    void test1() {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        assertThat(solution(3, words)).isEqualTo(new int[]{3, 3});
    }

    @Test
    void test2() {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        assertThat(solution(2, words)).isEqualTo(new int[]{1, 3});
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            String beforeWord = words[i - 1];
            if (!wordSet.contains(word) && beforeWord.charAt(beforeWord.length() - 1) == word.charAt(0)) {
                wordSet.add(word);
            } else {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }
        }
        return answer;
    }
}
