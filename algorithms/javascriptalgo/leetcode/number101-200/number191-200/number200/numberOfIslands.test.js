test("test", () => {
  const grid1 = [
    ["1", "1", "1", "1", "0"],
    ["1", "1", "0", "1", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "0", "0", "0"]
  ];
  const output1 = 1;

  const grid2 = [
    ["1", "1", "0", "0", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "1", "0", "0"],
    ["0", "0", "0", "1", "1"]
  ];
  const output2 = 3;

  expect(numIsLands(grid1)).toEqual(output1);
  expect(numIsLands(grid2)).toEqual(output2);
});

function numIsLands(grid) {
  const n = grid.length;
  const m = grid[0].length;
  const dx = [-1, 0, 1, 0];
  const dy = [0, -1, 0, 1];

  const dfs = (x, y) => {
    for (let i = 0; i < 4; i++) {
      let nx = x + dx[i];
      let my = y + dy[i];
      if (nx >= 0 && nx < n && my >= 0 && my < m && grid[nx][my] === '1') {
        grid[nx][my] = '0';
        dfs(nx, my);
      }
    }
  }

  let answer = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (grid[i][j] === '1') {
        answer++;
        grid[i][j] = '0';
        dfs(i, j);
      }
    }
  }

  return answer;
}
