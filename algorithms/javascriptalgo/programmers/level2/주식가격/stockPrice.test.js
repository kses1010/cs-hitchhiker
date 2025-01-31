test("test", () => {
  const prices = [1, 2, 3, 2, 3];

  expect(solution(prices)).toEqual([4, 3, 1, 1, 0]);
});

function solution(prices) {
  const length = prices.length;
  const answer = new Array(length).fill(0);
  const stack = [];

  for (let i = 0; i < length; i++) {
    while (stack.length !== 0 && prices[i] < prices[stack.at(-1)]) {
      const last = stack.pop();
      answer[last] = i - last;
    }
    stack.push(i);
  }

  while (stack.length !== 0) {
    const rest = stack.pop();
    answer[rest] = length - rest - 1;
  }

  return answer;
}
