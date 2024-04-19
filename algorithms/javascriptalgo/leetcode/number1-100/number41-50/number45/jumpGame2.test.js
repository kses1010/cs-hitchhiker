test("test", () => {
  const nums1 = [2, 3, 1, 1, 4];
  const nums2 = [2, 3, 0, 1, 4];

  expect(jump(nums1)).toEqual(2);
  expect(jump(nums2)).toEqual(2);
});

function jump(nums) {
  const end = nums.length - 1;
  let count = 0;
  let lastJump = 0;
  let curAt = 0;

  for (let i = 0; i < nums.length - 1; i++) {
    curAt = Math.max(curAt, i + nums[i]);
    if (i === lastJump) {
      count++
      lastJump = curAt;

      if (curAt >= end) {
        return count;
      }
    }
  }
  return count;
}
