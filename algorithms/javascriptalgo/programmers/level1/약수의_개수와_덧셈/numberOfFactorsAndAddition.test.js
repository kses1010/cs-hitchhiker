test("test", () => {
  const left1 = 13;
  const right1 = 17;

  const left2 = 24;
  const right2 = 27;

  expect(solution(left1, right1)).toEqual(43);
  expect(solution(left2, right2)).toEqual(52);
});

function solution(left, right) {
  let answer = 0;
  const counter = (num) => {
    let count = 0;
    for (let i = 1; i <= num; i++) {
      if (num % i === 0) {
        count++;
      }
    }
    return count;
  }

  for (let i = left; i <= right; i++) {
    let count = counter(i);
    if (count % 2 === 0) {
      answer += i;
    } else {
      answer -= i;
    }
  }

  return answer;
}
