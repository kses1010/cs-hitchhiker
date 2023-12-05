test("test", () => {
  const nums1 = [1, 1, 2];
  const nums2 = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];

  expect(removeDuplicates(nums1)).toEqual(2);
  expect(removeDuplicates(nums2)).toEqual(5);
});

function removeDuplicates(nums) {
  if (nums.length === 1) {
    return 1;
  }

  let target = nums[0];
  let answer = 1;
  for (let i = 1; i < nums.length; i++) {
    if (target !== nums[i]) {
      target = nums[i];
      nums[answer] = nums[i];
      answer++;
    }
  }

  return answer;
}
