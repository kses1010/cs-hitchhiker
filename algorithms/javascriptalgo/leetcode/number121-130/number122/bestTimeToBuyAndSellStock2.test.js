test("test", () => {
  const prices1 = [7, 1, 5, 3, 6, 4];
  const prices2 = [1, 2, 3, 4, 5];

  expect(maxProfit(prices1)).toEqual(7);
  expect(maxProfit(prices2)).toEqual(4);
  expect(maxProfit2(prices1)).toEqual(7);
  expect(maxProfit2(prices2)).toEqual(4);
});

function maxProfit(prices) {
  let answer = 0;

  for (let i = 0; i < prices.length - 1; i++) {
    if (prices[i] < prices[i + 1]) {
      answer += prices[i + 1] - prices[i];
    }
  }
  return answer;
}

function maxProfit2(prices) {
  let buy = 0;
  let sell = 0;
  let answer = 0;
  let days = prices.length;

  while (buy < days && sell < days) {
    while (buy < days - 1 && prices[buy + 1] < prices[buy]) {
      buy++; // 최저에서 사기
    }

    sell = buy;

    while (sell < days - 1 && prices[sell + 1] > prices[sell]) {
      sell++; // 고점에서 팔기
    }

    answer += prices[sell] - prices[buy];

    buy = sell + 1;
  }
  return answer;
}
