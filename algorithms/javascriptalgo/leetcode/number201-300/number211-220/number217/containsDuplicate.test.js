test("test", () => {
  const nums1 = [1, 2, 3, 3];
  const nums2 = [1, 2, 3, 4];

  expect(hasDuplicate(nums1)).toBeTruthy();
  expect(hasDuplicate(nums2)).toBeFalsy();
  expect(hasDuplicate2(nums1)).toBeTruthy();
  expect(hasDuplicate2(nums2)).toBeFalsy();
});

function hasDuplicate(nums) {
  const sets = new Set(nums);

  return sets.size !== nums.length;
}

function hasDuplicate2(nums) {
  nums.sort((a, b) => a - b);
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === nums[i - 1]) {
      return true;
    }
  }
  return false;
}
