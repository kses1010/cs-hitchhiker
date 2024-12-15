test("test", () => {
  const topping1 = [1, 2, 1, 3, 1, 4, 1, 2];
  const topping2 = [1, 2, 3, 1, 4];

  expect(solution(topping1)).toEqual(2);
  expect(solution(topping2)).toEqual(0);
  expect(solution2(topping1)).toEqual(2);
  expect(solution2(topping2)).toEqual(0);
});

// 시간초과
function solution(topping) {
  let answer = 0;

  const isPair = (topping1, topping2) => {
    const setSize1 = new Set(topping1).size;
    const setSize2 = new Set(topping2).size;
    return setSize1 === setSize2;
  }

  for (let i = 0; i < topping.length; i++) {
    let topping1 = topping.slice(0, i + 1);
    let topping2 = topping.slice(i + 1);
    if (isPair(topping1, topping2)) {
      answer++;
    }
  }

  return answer;
}

function solution2(topping) {
  let answer = 0;

  const left = new Set();
  const right = new Set();
  const toppingCount = new Array(10001).fill(0);

  if (topping.length === 0) return 0;

  topping.forEach((t) => {
    left.add(t);
    toppingCount[t]++;
  });

  topping.forEach((t) => {
    if (toppingCount[t] > 0) {
      toppingCount[t]--;
    }
    if (toppingCount[t] === 0) {
      left.delete(t);
    }
    right.add(t);
    if (left.size === right.size) {
      answer++;
    }
  });

  return answer;
}
