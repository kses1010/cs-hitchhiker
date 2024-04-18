test("test", () => {
  const nums1 = [0, 1, 2, 4, 5, 7];
  const nums2 = [0, 2, 3, 4, 6, 8, 9];

  expect(summaryRanges(nums1)).toEqual(["0->2", "4->5", "7"]);
  expect(summaryRanges(nums2)).toEqual(["0", "2->4", "6", "8->9"]);
});

function summaryRanges(nums) {
  const answer = [];
  let start = 0;

  for (let i = 1; i <= nums.length; i++) {
    if (nums[i - 1] + 1 !== nums[i] || i === nums.length) {
      if (nums[start] !== nums[i - 1]) {
        answer.push(`${nums[start]}->${nums[i - 1]}`);
      } else {
        answer.push(`${nums[i - 1]}`);
      }
      start = i;
    }
  }

  return answer;
}
