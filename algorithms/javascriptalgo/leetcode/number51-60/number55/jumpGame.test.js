test("test", () => {
  const nums1 = [2, 3, 1, 1, 4];
  const nums2 = [3, 2, 1, 0, 4];

  expect(canJump(nums1)).toBeTruthy();
  expect(canJump(nums2)).toBeFalsy();
});

// 최대 점프 길이를 의미함
function canJump(nums) {
  let lastJump = 0;
  for (let i = 0; i < nums.length; i++) {
    if (lastJump < i) {
      return false;
    }
    lastJump = Math.max(lastJump, i + nums[i]);
  }
  return true;
}
