test("test", () => {
  const nums1 = [1, 1, 1, 2, 2, 3];
  const k1 = 2;

  const nums2 = [1];
  const k2 = 1;

  expect(topKFrequent(nums1, k1)).toEqual([1, 2]);
  expect(topKFrequent(nums2, k2)).toEqual([1]);
});

function topKFrequent(nums, k) {
  const answer = [];
  const count = {};
  for (const num of nums) {
    count[num] = (count[num] || 0) + 1;
  }

  const arr = Object.entries(count);
  arr.sort((a, b) => b[1] - a[1]);

  for (let i = 0; i < k; i++) {
    answer.push(Number(arr[i][0]));
  }
  return answer;
}
