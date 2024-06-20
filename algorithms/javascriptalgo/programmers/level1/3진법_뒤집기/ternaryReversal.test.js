test("test", () => {
  const n1 = 45;
  const n2 = 125;

  expect(solution(n1)).toEqual(7);
  expect(solution(n2)).toEqual(229);
});

function solution(n) {
  const ternaryReverse = ((num) => {
    let s = [];
    while (num > 0) {
      let rest = num % 3;
      num = Math.floor(num / 3);
      s.push(rest);
    }
    return s.join('');
  });


  return parseInt(ternaryReverse(n), 3);
}
