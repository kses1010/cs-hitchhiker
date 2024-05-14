test("test", () => {
  const intervals1 = [[1, 3], [2, 6], [8, 10], [15, 18]];
  const output1 = [[1, 6], [8, 10], [15, 18]];

  const intervals2 = [[1, 4], [4, 5]];
  const output2 = [[1, 5]];

  expect(merge(intervals1)).toEqual(output1);
  expect(merge(intervals2)).toEqual(output2);
});

function merge(intervals) {
  const answer = [];
  intervals.sort((a, b) => a[0] - b[0]);
  let [start, end] = [intervals[0][0], intervals[0][1]];

  for (const interval of intervals) {
    if (interval[0] <= end) {
      end = Math.max(end, interval[1]);
    } else {
      answer.push([start, end]);
      [start, end] = [interval[0], interval[1]];
    }
  }
  answer.push([start, end]);
  return answer;
}
