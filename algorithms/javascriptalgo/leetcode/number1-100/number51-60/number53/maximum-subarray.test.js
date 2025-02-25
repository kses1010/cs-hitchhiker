test("test", () => {
  const nums1 = [-2, 1, -3, 4, -1, 2, 1, -5, 4];
  const nums2 = [1];
  const nums3 = [5, 4, -1, 7, 8];

  expect(maxSubArray(nums1)).toEqual(6);
  expect(maxSubArray(nums2)).toEqual(1);
  expect(maxSubArray(nums3)).toEqual(23);
});

/**
 * @param {number[]} nums
 * @return {number}
 */
const maxSubArray = function(nums) {
  let curSum = nums[0];
  let maxSum = nums[0];

  for (let i = 1; i < nums.length; i++) {
    curSum = Math.max(nums[i], curSum + nums[i]);
    maxSum = Math.max(curSum, maxSum);
  }

  return maxSum;
};
