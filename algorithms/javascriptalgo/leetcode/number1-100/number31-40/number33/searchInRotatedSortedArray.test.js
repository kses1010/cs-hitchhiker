test("test", () => {
  const nums1 = [4, 5, 6, 7, 0, 1, 2];
  const target1 = 0;

  const nums2 = [4, 5, 6, 7, 0, 1, 2];
  const target2 = 3;

  const nums3 = [1];
  const target3 = 0;

  expect(search(nums1, target1)).toEqual(4);
  expect(search(nums2, target2)).toEqual(-1);
  expect(search(nums3, target3)).toEqual(-1);

});

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const search = function (nums, target) {
  let left = 0;
  let right = nums.length - 1;

  while (left < right) {
    let mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] > nums[right]) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  let pivot = left;
  left = 0;
  right = nums.length - 1;

  while (left <= right) {
    const mid = Math.floor(left + (right - left) / 2);
    const midPivot = (pivot + mid) % nums.length;
    if (nums[midPivot] === target) {
      return midPivot;
    } else if (nums[midPivot] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return -1;
};
