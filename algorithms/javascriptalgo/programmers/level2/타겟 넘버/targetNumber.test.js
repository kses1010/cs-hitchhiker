test("test", () => {
  const numbers1 = [1, 1, 1, 1, 1];
  const target1 = 3;

  const numbers2 = [4, 1, 2, 1];
  const target2 = 4;

  expect(solution(numbers1, target1)).toBe(5);
  expect(solution(numbers2, target2)).toBe(2);
})

function solution(numbers, target) {
  let answer = 0;

  function dfs(L, numbers, target) {
    if (L === numbers.length) {
      if (target === 0) {
        answer++;
      }
    } else {
      let number = numbers[L];
      dfs(L + 1, numbers, target + number);
      dfs(L + 1, numbers, target - number);
    }
  }

  dfs(0, numbers, target);

  return answer;
}
