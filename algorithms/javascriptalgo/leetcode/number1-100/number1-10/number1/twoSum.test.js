test("test", () => {
  const nums1 = [2, 7, 11, 15];
  const target1 = 9;

  const nums2 = [3, 2, 4];
  const target2 = 6;

  const nums3 = [3, 3];
  const target3 = 6;

  expect(twoSum(nums1, target1)).toEqual([0, 1]);
  expect(twoSum(nums2, target2)).toEqual([1, 2]);
  expect(twoSum(nums3, target3)).toEqual([0, 1]);
});

function twoSum(nums, target) {
  const maps = new Map();
  for (let i = 0; i < nums.length; i++) {
    const diff = target - nums[i];
    if (maps.has(diff)) {
      return [maps.get(diff), i];
    }
    maps.set(nums[i], i);
  }
  return [];
}
