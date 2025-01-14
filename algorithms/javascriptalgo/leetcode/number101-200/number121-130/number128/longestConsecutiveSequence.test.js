test("test", () => {
  const nums1 = [2, 20, 4, 10, 3, 4, 5];
  const nums2 = [0, 3, 2, 5, 4, 6, 1, 1];

  expect(longestConsecutive(nums1)).toEqual(4);
  expect(longestConsecutive(nums2)).toEqual(7);
});

function longestConsecutive(nums) {
  let answer = 0;
  const set = new Set(nums);

  for (const num of set) {
    if (!set.has(num - 1)) {
      let length = 1;
      while (set.has(num + length)) {
        length++;
      }
      answer = Math.max(answer, length);
    }
  }
  return answer;
}
