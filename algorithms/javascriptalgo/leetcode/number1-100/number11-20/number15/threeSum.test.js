test("test", () => {
  const nums1 = [-1, 0, 1, 2, -1, -4];
  const output1 = [[-1, -1, 2], [-1, 0, 1]];

  const nums2 = [0, 1, 1];
  const output2 = [];

  const nums3 = [0, 0, 0];
  const output3 = [[0, 0, 0]];

  expect(threeSum(nums1)).toEqual(output1);
  expect(threeSum(nums2)).toEqual(output2);
  expect(threeSum(nums3)).toEqual(output3);
});

function threeSum(nums) {
  const answer = [];
  nums.sort((a, b) => a - b);
  let length = nums.length;

  for (let i = 0; i < length - 2; i++) {
    if (i > 0 && nums[i] === nums[i - 1]) continue;

    let lt = i + 1;
    let rt = length - 1;

    while (lt < rt) {
      let total = nums[i] + nums[lt] + nums[rt];

      if (total < 0) {
        lt++;
      } else if (total > 0) {
        rt--;
      } else {
        answer.push([nums[i], nums[lt], nums[rt]]);

        while (lt < rt && nums[lt] === nums[lt + 1]) {
          lt++;
        }
        while (lt < rt && nums[rt] === nums[rt - 1]) {
          rt--;
        }

        lt++;
        rt--;
      }
    }
  }

  return answer;
}
