test("test", () => {
  const citations1 = [3, 0, 6, 1, 5];
  const citations2 = [1, 3, 1];

  expect(hIndex(citations1)).toEqual(3);
  expect(hIndex(citations2)).toEqual(1);
});

function hIndex(citations) {
  citations.sort((a, b) => b - a);
  let answer = 0;
  while (answer + 1 <= citations[answer]) {
    answer++;
  }

  return answer;
}
