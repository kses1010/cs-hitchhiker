package leetcode.number101to200.number191to200.number200;


public class Solution {

    private int n;
    private int m;
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int answer = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    grid[i][j] = '0';
                    dfs(i, j, grid);
                }
            }
        }
        return answer;
    }

    private void dfs(int x, int y, char[][] grid) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int my = y + dy[i];
            if (nx >= 0 && nx < n && my >= 0 && my < m && grid[nx][my] == '1') {
                grid[nx][my] = '0';
                dfs(nx, my, grid);
            }
        }
    }
}
