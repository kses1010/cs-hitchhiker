test("test", () => {
  const m = 4;
  const n = 3;
  const puddles = [[2, 2]];

  expect(solution(m, n, puddles)).toEqual(4);
});

function solution(m, n, puddles) {
  const dp = Array.from({length: n + 1}, () => Array(m + 1).fill(0));

  const isPuddle = Array.from({length: n + 1}, () => Array(m + 1).fill(false));
  for (const [x, y] of puddles) {
    isPuddle[y][x] = true;
  }

  dp[1][1] = 1;

  for (let row = 1; row <= n; row++) {
    for (let  col = 1; col <= m; col++) {
      if (row === 1 && col === 1) continue;

      if (isPuddle[row][col]) {
        dp[row][col] = 0;
      } else {
        dp[row][col] = (dp[row - 1][col] + dp[row][col - 1]) % 1_000_000_007;
      }
    }
  }

  return dp[n][m];
}
