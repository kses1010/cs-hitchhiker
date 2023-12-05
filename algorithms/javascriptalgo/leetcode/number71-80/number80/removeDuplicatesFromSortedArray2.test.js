test("test", () => {
  const nums1 = [1, 1, 1, 2, 2, 3];
  const nums2 = [0, 0, 1, 1, 1, 1, 2, 3, 3];

  expect(removeDuplicates(nums1)).toEqual(5);
  expect(removeDuplicates(nums2)).toEqual(7);
});

function removeDuplicates(nums) {
  let index = 0;
  for (const num of nums) {
    if (index < 2 || num > nums[index - 2]) {
      nums[index] = num;
      index++;
    }
  }

  return index;
}
