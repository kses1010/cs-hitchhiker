test("test", () => {
  let n1 = 5;
  let n2 = 6;
  let n3 = 5000;

  expect(solution(n1)).toBe(2);
  expect(solution(n2)).toBe(2);
  expect(solution(n3)).toBe(5);
});

function solution(n) {
  if (n === 1) return 1;
  let answer = 0;
  while (n !== 0) {
    if (n % 2 === 0) {
      n /= 2;
    } else {
      n--;
      answer++;
    }
  }
  return answer;
}
