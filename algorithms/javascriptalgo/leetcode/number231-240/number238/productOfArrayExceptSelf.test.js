test("test", () => {
  const nums1 = [1, 2, 3, 4];
  const nums2 = [-1, 1, 0, -3, 3];

  expect(productExceptSelf(nums1)).toEqual([24, 12, 8, 6]);
  expect(productExceptSelf(nums2)).toEqual([0, 0, 9, 0, 0]);
});

function productExceptSelf(nums) {
  let answer = [];
  let left = 1;
  let right = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    answer[i] = right;
    right *= nums[i];
  }
  for (let i = 0; i < nums.length; i++) {
    answer[i] *= left;
    if (answer[i] === -0) {
      answer[i] = 0;
    }
    left *= nums[i];
  }
  return answer;
}
