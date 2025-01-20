test("test", () => {
  const operations1 = ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"];
  const operations2 = ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]

  expect(solution(operations1)).toEqual([0, 0]);
  expect(solution(operations2)).toEqual([333, -45]);
});

function solution(operations) {
  let list = [];
  operations.forEach(item => {
    const [oper, num] = item.split(" ");
    if (oper === "I") {
      list.push(Number(num));
    } else {
      if (list.length === 0) {
        return;
      }
      const number = Number(num);
      const value = (number === -1 ? Math.min : Math.max)(...list);
      const deleteIndex = list.findIndex(e => e === value);

      list.splice(deleteIndex, 1);
    }
  })

  if (list.length === 0) {
    return [0, 0];
  }
  return [Math.max(...list), Math.min(...list)];
}

