package programmers.level2.fatigue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FatigueTest {

    static boolean[] visited;
    static int answer;

    @Test
    void test() {
        int k = 80;
        int[][] dungeons = {
            {80, 20},
            {50, 40},
            {30, 10}
        };

        assertThat(solution(k, dungeons)).isEqualTo(3);
    }

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int L, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(L + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
            answer = Math.max(answer, L);
        }
    }
}
