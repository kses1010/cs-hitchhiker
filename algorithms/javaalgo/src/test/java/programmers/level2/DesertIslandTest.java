package programmers.level2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DesertIslandTest {

    static int[][] newMaps;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    @Test
    void test() {
        String[] maps1 = {"X591X", "X1X5X", "X231X", "1XXX1"};
        String[] maps2 = {"XXX", "XXX", "XXX"};

        assertAll(
            () -> assertThat(solution(maps1)).isEqualTo(new int[]{1, 1, 27}),
            () -> assertThat(solution(maps2)).isEqualTo(new int[]{-1})
        );
    }

    public int[] solution(String[] maps) {
        List<Integer> answers = new ArrayList<>();
        newMaps = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') {
                    newMaps[i][j] = 0;
                } else {
                    newMaps[i][j] = c - 48;
                }
            }
        }

        for (int i = 0; i < newMaps.length; i++) {
            for (int j = 0; j < newMaps[0].length; j++) {
                if (newMaps[i][j] != 0) {
                    count = 0;
                    dfs(newMaps, i, j);
                    if (count != 0) {
                        answers.add(count);
                    }

                }
            }
        }
        if (answers.isEmpty()) {
            return new int[]{-1};
        }
        Collections.sort(answers);
        return answers.stream().mapToInt(i -> i).toArray();
    }

    public void dfs(int[][] maps, int x, int y) {
        count += maps[x][y];
        maps[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length && maps[nx][ny] != 0) {
                dfs(maps, nx, ny);
            }
        }
    }
}
