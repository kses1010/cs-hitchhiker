test("test", () => {
  const nums1 = [3, 4, 5, 1, 2];
  const nums2 = [4, 5, 6, 7, 0, 1, 2];
  const nums3 = [11, 13, 15, 17];

  expect(findMin(nums1)).toEqual(1);
  expect(findMin(nums2)).toEqual(0);
  expect(findMin(nums3)).toEqual(11);
});


/**
 * @param {number[]} nums
 * @return {number}
 */
const findMin = function(nums) {
  let left = 0;
  let right = nums.length - 1;

  while (left < right) {
    const mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] > nums[right]) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return nums[left];
};
