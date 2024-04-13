test("test", () => {
  const gas1 = [1, 2, 3, 4, 5];
  const cost1 = [3, 4, 5, 1, 2];

  const gas2 = [2, 3, 4];
  const cost2 = [3, 4, 3];

  expect(canCompleteCircuit(gas1, cost1)).toEqual(3);
  expect(canCompleteCircuit(gas2, cost2)).toEqual(-1);
});

function canCompleteCircuit(gas, cost) {
  let tanks = 0;
  for (let i = 0; i < gas.length; i++) {
    tanks += gas[i] - cost[i];
  }
  if (tanks < 0) {
    return -1;
  }

  let start = 0;
  let fuel = 0;
  for (let i = 0; i < gas.length; i++) {
    if (gas[i] + fuel < cost[i]) {
      start = i + 1;
      fuel = 0;
    } else {
      fuel += gas[i] - cost[i];
    }
  }
  return start;
}
