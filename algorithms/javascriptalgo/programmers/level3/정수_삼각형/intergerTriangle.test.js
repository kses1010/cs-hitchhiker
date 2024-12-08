test("test", () => {
  const triangle = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]];

  expect(solution(triangle)).toBe(30);
});

function solution(triangle) {
  let answer = 0;
  if (triangle.length === 1) {
    return triangle[0][0];
  }
  for (let row = 1; row < triangle.length; row++) {
    for (let col = 0; col < triangle[row].length; col++) {
      if (col === 0) {
        triangle[row][col] += triangle[row - 1][col];
      } else if (row === col) {
        triangle[row][col] += triangle[row - 1][col - 1];
      } else {
        triangle[row][col] += Math.max(triangle[row - 1][col - 1], triangle[row - 1][col]);
      }
      answer = Math.max(answer, triangle[row][col]);
    }
  }

  return answer;
}

function solution2(triangle) {
  return Math.max(...triangle.reduce((cost, line) => {
    return line.map((v, index) => {
      return v + Math.max((index < cost.length ? cost[index] : 0), (index > 0 ? cost[index - 1] : 0));
    });
  }, []));
}
