test("test", () => {
  const price = 3;
  const money = 20;
  const count = 4;

  expect(solution(price, money, count)).toEqual(10);
});

function solution(price, money, count) {
  let totalPrice = 0;
  for (let i = 1; i <= count; i++) {
    totalPrice += i * price;
  }
  let rest = totalPrice - money;

  return rest < 0 ? 0 : rest;
}
