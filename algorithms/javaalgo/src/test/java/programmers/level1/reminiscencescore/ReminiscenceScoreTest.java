package programmers.level1.reminiscencescore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ReminiscenceScoreTest {

    @Test
    void test() {
        String[] name1 = {"may", "kein", "kain", "radi"};
        int[] yearning1 = {5, 10, 1, 3};
        String[][] photo1 = {
            {"may", "kein", "kain", "radi"},
            {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}
        };

        String[] name2 = {"kali", "mari", "don"};
        int[] yearning2 = {11, 1, 55};
        String[][] photo2 = {
            {"kali", "mari", "don"},
            {"pony", "tom", "teddy"},
            {"con", "mona", "don"}
        };

        String[] name3 = {"may", "kein", "kain", "radi"};
        int[] yearning3 = {5, 10, 1, 3};
        String[][] photo3 = {
            {"may"},
            {"kein", "deny", "may"},
            {"kon", "coni"}
        };

        assertAll(
            () -> assertThat(solution(name1, yearning1, photo1)).isEqualTo(new int[]{19, 15, 6}),
            () -> assertThat(solution(name2, yearning2, photo2)).isEqualTo(new int[]{67, 0, 55}),
            () -> assertThat(solution(name3, yearning3, photo3)).isEqualTo(new int[]{5, 15, 0})
        );
    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            maps.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            String[] line = photo[i];
            for (String p : line) {
                if (maps.containsKey(p)) {
                    score += maps.get(p);
                }
            }
            answer[i] = score;
        }
        return answer;
    }
}
