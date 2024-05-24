test("test", () => {
  const nums = [1, 3, 5, 6];
  const target1 = 5;
  const target2 = 2;
  const target3 = 7;

  expect(searchInsert(nums, target1)).toEqual(2);
  expect(searchInsert(nums, target2)).toEqual(1);
  expect(searchInsert(nums, target3)).toEqual(4);
});

function searchInsert(nums, target) {
  let left = 0;
  let right = nums.length - 1;

  while (left <= right) {
    let mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] === target) return mid;
    if (nums[mid] > target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return left;
}
