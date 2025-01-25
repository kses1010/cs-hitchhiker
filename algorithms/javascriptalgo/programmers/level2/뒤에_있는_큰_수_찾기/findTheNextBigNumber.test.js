test("test", () => {
  const numbers1 = [2, 3, 3, 5];
  const numbers2 = [9, 1, 5, 3, 6, 2];

  expect(solution(numbers1)).toEqual([3, 5, 5, -1]);
  expect(solution(numbers2)).toEqual([-1, 5, 6, 6, -1, -1]);
});

function solution(numbers) {
  const answer = new Array(numbers.length).fill(-1);
  const stack = [];

  for (let i = 0; i < numbers.length; i++) {
    while (stack.length !== 0 && numbers[i] > numbers[stack.at(-1)]) {
      const last = stack.pop();
      answer[last] = numbers[i];
    }
    stack.push(i);
  }

  return answer;
}
