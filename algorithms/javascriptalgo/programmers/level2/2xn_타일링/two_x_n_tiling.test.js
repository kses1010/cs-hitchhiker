test("test", () => {
  const n = 4;

  expect(solution(n)).toBe(5);
});

function solution(n) {
  const DIV = 1_000_000_007;

  if (n === 1) return 1;
  if (n === 2) return 2;

  let prev = 1;
  let curr = 2;
  let next = 0;

  for (let i = 3; i <= n; i++) {
    next = (prev + curr) % DIV;
    prev = curr;
    curr = next;
  }

  return curr;
}
