test("test", () => {
  const nums1 = [1, 3, 4, 2, 2];
  const nums2 = [3, 1, 3, 4, 2];
  const nums3 = [3, 3, 3, 3, 3];

  expect(findDuplicate(nums1)).toEqual(2);
  expect(findDuplicate(nums2)).toEqual(3);
  expect(findDuplicate(nums3)).toEqual(3);
});

/**
 * @param {number[]} nums
 * @return {number}
 */
const findDuplicate = function(nums) {
  let slow = nums[0];
  let fast = nums[0];
  while (true) {
    slow = nums[slow];
    fast = nums[nums[fast]];
    if (slow === fast) break;
  }

  slow = nums[0];
  while (slow !== fast) {
    slow = nums[slow];
    fast = nums[fast];
  }

  return slow;
};
