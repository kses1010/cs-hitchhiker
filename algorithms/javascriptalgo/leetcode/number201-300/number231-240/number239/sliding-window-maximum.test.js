test("test", () => {
  const nums1 = [1, 3, -1, -3, 5, 3, 6, 7];
  const k1 = 3;

  const nums2 = [1];
  const k2 = 1;

  expect(maxSlidingWindow(nums1, k1)).toEqual([3, 3, 5, 5, 6, 7]);
  expect(maxSlidingWindow(nums2, k2)).toEqual([1]);
});

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
const maxSlidingWindow = function(nums, k) {
  const length = nums.length;
  if (length === 1 && k === 1) return nums;

  const answer = Array(length - k + 1).fill(0);
  let left = 0;

  const q = [];

  for (let right = 0; right < length; right++) {
    if (q.length !== 0 && q.at(0) < right - k + 1) {
      q.shift();
    }
    while (q.length !== 0 && nums[q.at(-1)] < nums[right]) {
      q.pop();
    }
    q.push(right);
    if (right >= k - 1) {
      answer[left] = nums[q.at(0)];
      left++;
    }
  }
  return answer;
};
