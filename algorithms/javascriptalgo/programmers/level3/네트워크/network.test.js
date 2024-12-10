test("test", () => {
  const computers1 = [[1, 1, 0], [1, 1, 0], [0, 0, 1]];
  const computers2 = [[1, 1, 0], [1, 1, 1], [0, 1, 1]];

  expect(solution(3, computers1)).toBe(2);
  expect(solution(3, computers2)).toBe(1);
})

function solution(n, computers) {
  let answer = 0;
  const visited = new Array(computers.length).fill(false);

  const dfs = (start, computers) => {
    visited[start] = true;
    for (let i = 0; i < computers.length; i++) {
      if (!visited[i] && computers[start][i] === 1) {
        dfs(i, computers);
      }
    }
  }

  for (let i = 0; i < computers.length; i++) {
    if (!visited[i]) {
      answer++;
      dfs(i, computers);
    }
  }

  return answer;
}
