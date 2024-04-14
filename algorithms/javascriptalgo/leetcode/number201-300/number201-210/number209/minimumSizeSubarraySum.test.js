test("test", () => {
  const target1 = 7;
  const nums1 = [2, 3, 1, 2, 4, 3];
  const target2 = 4;
  const nums2 = [1, 4, 4];
  const target3 = 11;
  const nums3 = [1, 1, 1, 1, 1, 1, 1, 1];
  const target4 = 11;
  const nums4 = [1, 2, 3, 4, 5];

  expect(minSubArrayLen(target1, nums1)).toEqual(2);
  expect(minSubArrayLen(target2, nums2)).toEqual(1);
  expect(minSubArrayLen(target3, nums3)).toEqual(0);
  expect(minSubArrayLen(target4, nums4)).toEqual(3);
});

function minSubArrayLen(target, nums) {
  let answer = Infinity;
  let start = 0;
  let end = 0;
  let sum = nums[start];

  while (start < nums.length) {
    if (answer === 1) return answer;
    if (sum <= target) {
      if (sum === target) {
        answer = Math.min(answer, end - start + 1);
      }
      if (end !== nums.length - 1) {
        end++;
        sum += nums[end];
      } else {
        sum -= nums[start];
        start++;
      }
    } else {
      answer = Math.min(answer, end - start + 1);
      sum -= nums[start];
      start++;
    }
  }
  if (answer === Infinity) {
    return 0;
  }

  return answer;
}
