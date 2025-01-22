test("test", () => {
  const n1 = 3;
  const output1 = ["((()))", "(()())", "(())()", "()(())", "()()()"];

  const n2 = 1;
  const output2 = ["()"];

  expect(generateParenthesis(n1)).toEqual(output1);
  expect(generateParenthesis(n2)).toEqual(output2);
});

/**
 * @param {number} n
 * @return {string[]}
 */
const generateParenthesis = function(n) {
  const dfs = (openBr, closeBr, n, res, bracket) => {
    if (openBr === closeBr && openBr === n) {
      res.push(bracket);
      return;
    }
    if (openBr < n) {
      dfs(openBr + 1, closeBr, n, res, bracket + "(");
    }
    if (closeBr < openBr) {
      dfs(openBr, closeBr + 1, n, res, bracket + ")");
    }
  }

  const answer = [];
  dfs(0, 0, n, answer, "");
  return answer;
};
