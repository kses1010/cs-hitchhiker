test("test", () => {
  const dirs1 = "ULURRDLLU";
  const dirs2 = "LULLLLLLU";

  expect(solution(dirs1)).toBe(7);
  expect(solution(dirs2)).toBe(7);
});

function solution(dirs) {
  const move = { L: [-1, 0], R: [1, 0], U: [0, 1], D: [0, -1] };
  let now = [0, 0];
  let visited = new Set();

  for (let dir of dirs) {
    let nx = now[0] + move[dir][0];
    let ny = now[1] + move[dir][1];

    if (nx > 5 || nx < -5 || ny > 5 || ny < -5) continue;

    visited.add("" + now[0] + now[1] + nx + ny);
    visited.add("" + nx + ny + now[0] + now[1]);

    now = [nx, ny];
  }

  return visited.size / 2;
}
