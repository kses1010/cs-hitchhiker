test("test", () => {
  const prices1 = [7, 1, 5, 3, 6, 4];
  const prices2 = [7, 6, 4, 3, 1];

  expect(maxProfit(prices1)).toEqual(5);
  expect(maxProfit(prices2)).toEqual(0);
  expect(maxProfit2(prices1)).toEqual(5);
  expect(maxProfit2(prices2)).toEqual(0);
});

function maxProfit(prices) {
  let answer = 0;
  let minPrice = Infinity;

  for (const price of prices) {
    minPrice = Math.min(minPrice, price);
    answer = Math.max(answer, price - minPrice);
  }

  return answer;
}

function maxProfit2(prices) {
  let buy = 0;
  let sell = 1;
  let answer = 0;

  while (sell < prices.length) {
    if (prices[buy] < prices[sell]) {
      let profit = prices[sell] - prices[buy];
      answer = Math.max(answer, profit);
    } else {
      buy = sell;
    }
    sell++;
  }

  return answer;
}
