test("test", () => {
  const nums1 = [3, 2, 2, 3];
  const val1 = 3;

  const nums2 = [0, 1, 2, 2, 3, 0, 4, 2];
  const val2 = 2;

  expect(removeElement(nums1, val1)).toEqual(2);
  expect(removeElement(nums2, val2)).toEqual(5);
});

function removeElement(nums, val) {
  let index = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== val) {
      nums[index] = nums[i];
      index++;
    }
  }

  return index;
}
