test("test", () => {
  const order1 = [4, 3, 1, 2, 5];
  const order2 = [5, 4, 3, 2, 1];

  expect(solution(order1)).toEqual(2);
  expect(solution(order2)).toEqual(5);
})

function solution(order) {
  const n = order.length;
  let requiredIndex = 0;
  let currentBox = 1;
  const stack = [];

  while (requiredIndex < n) {
    if (currentBox <= n && currentBox === order[requiredIndex]) {
      currentBox++;
      requiredIndex++;
    } else if (stack.length !== 0 && stack.at(-1) === order[requiredIndex]) {
      stack.pop();
      requiredIndex++;
    } else if (currentBox <= n) {
      stack.push(currentBox);
      currentBox++;
    } else {
      break;
    }
  }
  return requiredIndex;
}
