test("test", () => {
  const board1 = [["X", "X", "X", "X"], ["X", "O", "O", "X"], ["X", "X", "O", "X"], ["X", "O", "X", "X"]];
  const output1 = [["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "O", "X", "X"]];

  const board2 = [["X"]];
  const output2 = [["X"]];

  expect(solve(board1)).toEqual(output1);
  expect(solve(board2)).toEqual(output2);
});

function solve(board) {
  const dx = [-1, 0, 1, 0];
  const dy = [0, -1, 0, 1];
  const m = board.length;
  const n = board[0].length;

  const dfs = (x, y) => {
    for (let i = 0; i < 4; i++) {
      let nx = x + dx[i];
      let ny = y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < m && ny < n && board[nx][ny] !== 'visited' && board[nx][ny] === 'O') {
        board[nx][ny] = 'visited';
        dfs(nx, ny);
      }
    }
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] === 'O' && (i === 0 || j === 0 || i === m - 1 || j === n - 1)) {
        board[i][j] = 'visited';
        dfs(i, j);
      }
    }
  }

  for(let i = 0; i < m; i++) {
    for(let j = 0; j < n; j++) {
      if(board[i][j] === 'visited') {
        board[i][j] = 'O';
      } else  {
        board[i][j] = 'X';
      }
    }
  }

  return board;
}
