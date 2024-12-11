test("test", () => {
  const maps1 = [[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 1], [0, 0, 0, 0, 1]];
  const maps2 = [[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 0], [0, 0, 0, 0, 1]];

  expect(solution(maps1)).toBe(11);
  expect(solution(maps2)).toBe(-1);
})

function solution(maps) {
  const n = maps.length;
  const m = maps[0].length;
  const dx = [-1, 0, 1, 0];
  const dy = [0, -1, 0, 1];

  const queue = [[0, 0, 1]];
  maps[0][0] = 0;

  while (queue.length > 0) {
    let [x, y, distance] = queue.pop();

    if (x === n - 1 && y === m - 1) {
      return distance;
    }

    for (let i = 0; i < 4; i++) {
      let nx = x + dx[i];
      let ny = y + dy[i];

      if (nx >= 0 && ny < n && ny >= 0 && ny < m && maps[nx][ny] === 1) {
        queue.unshift([nx, ny, distance + 1]);
        maps[nx][ny] = 0;
      }
    }
  }

  return - 1;
}
