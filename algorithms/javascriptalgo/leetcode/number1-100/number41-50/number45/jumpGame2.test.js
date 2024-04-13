test("test", () => {
  const nums1 = [2, 3, 1, 1, 4];
  const nums2 = [2, 3, 0, 1, 4];

  expect(jump(nums1)).toEqual(2);
  expect(jump(nums2)).toEqual(2);
});

function jump(nums) {
  const end = nums.length - 1;
  let answer = 0;
  let lastJump = 0;
  let curJump = 0;

  for (let i = 0; i < nums.length - 1; i++) {
    curJump = Math.max(curJump, i + nums[i]);
    if (i === lastJump) {
      answer++
      lastJump = curJump;

      if (curJump >= end) {
        return answer;
      }
    }
  }
  return answer;
}
