test("test", () => {
  const numbers1 = [2, 1, 3, 4, 1];
  const numbers2 = [5, 0, 2, 7];

  expect(solution(numbers1)).toEqual([2, 3, 4, 5, 6, 7]);
  expect(solution(numbers2)).toEqual([2, 5, 7, 9, 12]);
});

function solution(numbers) {
  const sets = new Set();
  for (let i = 0; i < numbers.length; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      sets.add(numbers[i] + numbers[j]);
    }
  }
  const answer = [...sets];
  return answer.sort((a, b) => a - b);
}
