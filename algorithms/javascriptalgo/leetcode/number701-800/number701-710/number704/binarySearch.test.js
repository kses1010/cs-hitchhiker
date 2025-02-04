test("test", () => {
  const nums = [-1, 0, 3, 5, 9, 12];
  const target1 = 9;
  const target2 = 2;

  expect(search(nums, target1)).toEqual(4);
  expect(search(nums, target2)).toEqual(-1);
});

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const search = function (nums, target) {
  let left = 0;
  let right = nums.length - 1;

  while (left <= right) {
    const mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] < target) {
      left++;
    } else if (nums[mid] > target) {
      right--;
    } else {
      return mid;
    }
  }
  return -1;
};
