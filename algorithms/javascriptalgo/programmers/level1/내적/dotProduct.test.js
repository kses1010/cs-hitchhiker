test("test", () => {
  const a1 = [1, 2, 3, 4];
  const b1 = [-3, -1, 0, 2];

  const a2 = [-1, 0, 1];
  const b2 = [1, 0, -1];

  expect(solution(a1, b1)).toEqual(3);
  expect(solution(a2, b2)).toEqual(-2);
});

function solution(a, b) {
  let answer = 0;
  for (let i = 0; i < a.length; i++) {
    answer += a[i] * b[i];
  }

  return answer;
}
