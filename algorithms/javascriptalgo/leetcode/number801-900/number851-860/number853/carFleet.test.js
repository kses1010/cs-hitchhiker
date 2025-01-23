test("test", () => {
  const target1 = 12;
  const position1 = [10, 8, 0, 5, 3];
  const speed1 = [2, 4, 1, 1, 3]
  const output1 = 3;

  const target2 = 10;
  const position2 = [3];
  const speed2 = [3];
  const output2 = 1;

  const target3 = 100;
  const position3 = [0, 2, 4];
  const speed3 = [4, 2, 1];
  const output3 = 1;

  expect(carFleet(target1, position1, speed1)).toEqual(output1);
  expect(carFleet(target2, position2, speed2)).toEqual(output2);
  expect(carFleet(target3, position3, speed3)).toEqual(output3);
});

/**
 * @param {number} target
 * @param {number[]} position
 * @param {number[]} speed
 * @return {number}
 */
const carFleet = function(target, position, speed) {
  const pairs = position.map((pos, i) => [pos, speed[i]]);
  pairs.sort((a, b) => b[0] - a[0]);
  const stack = [];

  for (const [pos, sp] of pairs) {
    stack.push((target - pos) / sp);
    if (stack.length >= 2 && stack.at(-1) <= stack.at(-2)) {
      stack.pop();
    }
  }
  return stack.length;
};
