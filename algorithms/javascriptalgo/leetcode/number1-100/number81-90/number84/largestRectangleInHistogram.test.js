test("test", () => {
  const heights1 = [2, 1, 5, 6, 2, 3];
  const heights2 = [1, 3, 7];

  expect(largestRectangleArea(heights1)).toEqual(10);
  expect(largestRectangleArea(heights2)).toEqual(7);
});

function largestRectangleArea(heights) {
  let answer = 0;
  const stack = [];

  for (let i = 0; i < heights.length; i++) {
    let start = i;
    let h = heights[i];
    while (stack.length !== 0 && stack.at(-1)[1] > h) {
      const [index, height] = stack.pop();
      answer = Math.max(answer, height * (i - index));
      start = index;
    }
    stack.push([start, h]);
  }

  for (const [index, height] of stack) {
    answer = Math.max(answer, height * (heights.length - index));
  }
  return answer;
}

