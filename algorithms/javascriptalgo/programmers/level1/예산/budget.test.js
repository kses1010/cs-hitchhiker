test("test", () => {
  const d1 = [1, 3, 2, 5, 4];
  const d2 = [2, 2, 3, 3];
  const budget1 = 9;
  const budget2 = 10;

  expect(solution(d1, budget1)).toEqual(3);
  expect(solution(d2, budget2)).toEqual(4);
});

function solution(d, budget) {
  d.sort((a, b) => a - b);
  let total = 0;
  for (let i = 0; i < d.length; i++) {
    total += d[i];
    if (total > budget) {
      return i;
    }
  }
  return d.length;
}
