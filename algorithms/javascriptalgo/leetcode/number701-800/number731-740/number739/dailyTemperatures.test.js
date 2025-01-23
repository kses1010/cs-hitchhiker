test("test", () => {
  const temperatures1 = [73, 74, 75, 71, 69, 72, 76, 73];
  const output1 = [1, 1, 4, 2, 1, 1, 0, 0];

  const temperatures2 = [30, 40, 50, 60];
  const output2 = [1, 1, 1, 0];

  const temperatures3 = [30, 60, 90];
  const output3 = [1, 1, 0];

  expect(dailyTemperatures(temperatures1)).toEqual(output1);
  expect(dailyTemperatures(temperatures2)).toEqual(output2);
  expect(dailyTemperatures(temperatures3)).toEqual(output3);
});

/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
const dailyTemperatures = function(temperatures) {
  const answer = new Array(temperatures.length).fill(0);
  const stack = [];

  for (let i = 0; i < temperatures.length; i++) {
    while (stack.length !== 0 && temperatures[i] > temperatures[stack[stack.length - 1]]) {
      const last = stack.pop();
      answer[last] = i - last;
    }
    stack.push(i);
  }
  return answer;
};
