test("test", () => {
  const land = [
    [1, 2, 3, 5],
    [5, 6, 7, 8],
    [4, 3, 2, 1]
  ];

  expect(solution(land)).toEqual(16);
});

function solution(land) {
  const row = land.length;
  const col = land[0].length;

  for (let i = 1; i < row; i++) {
    for (let j = 0; j < col; j++) {
      const maxPrev = Math.max(...land[i - 1].filter((_, idx) => idx !== j));
      land[i][j] += maxPrev;
    }
  }

  return Math.max(...land[row - 1]);
}
