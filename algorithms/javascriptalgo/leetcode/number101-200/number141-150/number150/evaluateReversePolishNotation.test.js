test("test", () => {
  const tokens1 = ["2", "1", "+", "3", "*"];
  const output1 = 9;

  const tokens2 = ["4", "13", "5", "/", "+"];
  const output2 = 6;

  const tokens3 = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"];
  const output3 = 22;

  expect(evalRPN(tokens1)).toEqual(output1);
  expect(evalRPN(tokens2)).toEqual(output2);
  expect(evalRPN(tokens3)).toEqual(output3);
});

/**
 * @param {string[]} tokens
 * @return {number}
 */
const evalRPN = function(tokens) {
  const stack = [];
  for (const t of tokens) {
    if (t === "+") {
      stack.push(stack.pop() + stack.pop());
    } else if (t === "-") {
      const a = stack.pop();
      const b = stack.pop();
      stack.push(b - a);
    } else if (t === "*") {
      stack.push(stack.pop() * stack.pop());
    } else if (t === "/") {
      const a = stack.pop();
      const b = stack.pop();
      stack.push(Math.trunc(b / a));
    } else {
      stack.push(Number(t));
    }
  }
  return stack.pop();
};
