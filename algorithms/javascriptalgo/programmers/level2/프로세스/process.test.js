test("test", () => {
  const priorities1 = [2, 1, 3, 2];
  const location1 = 2;

  const priorities2 = [1, 1, 9, 1, 1, 1];
  const location2 = 0;

  expect(solution(priorities1, location1)).toBe(1);
  expect(solution(priorities2, location2)).toBe(5);
})

function solution(priorities, location) {
  let queue = priorities.map((priority, index) => {
    return {
      index: index, priority: priority
    }
  });

  const process = [];

  while (queue.length > 0) {
    let first = queue.shift();
    let hasHighPriority = queue.some(item => item.priority > first.priority);
    if (hasHighPriority) {
      queue.push(first);
    } else {
      process.push(first.index);
    }
  }

  return process.findIndex(e => e === location) + 1;
}
