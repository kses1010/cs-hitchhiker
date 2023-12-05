test("test", () => {
  const nums1 = [1, 2, 3, 4, 5, 6, 7];
  const k1 = 3;

  const nums2 = [-1, -100, 3, 99];
  const k2 = 2;

  expect(rotate(nums1, k1)).toEqual([5, 6, 7, 1, 2, 3, 4]);
  expect(rotate(nums2, k2)).toEqual([3, 99, -1, -100]);
});

function rotate(nums, k) {

  const reverse = (start, end) => {
    while (start < end) {
      [nums[start], nums[end]] = [nums[end], nums[start]];
      start++;
      end--;
    }
  }

  const target = k % nums.length;
  reverse(0, nums.length - 1);
  reverse(0, target - 1);
  reverse(target, nums.length - 1);

  return nums;
}
