test("test", () => {
  const nums1 = [3, 2, 3];
  const nums2 = [2, 2, 1, 1, 1, 2, 2];

  expect(majorityElement(nums1)).toEqual(3);
  expect(majorityElement(nums2)).toEqual(2);
  expect(majorityElement2(nums1)).toEqual(3);
  expect(majorityElement2(nums2)).toEqual(2);
});

function majorityElement(nums) {
  const map = {};
  const limit = (nums.length / 2).toFixed();
  for (const num of nums) {
    map[num] = map[num] + 1 || 1;
    if (map[num] >= limit) {
      return num;
    }
  }
  return 0;
}

// O(1) spaces
function majorityElement2(nums) {
  let answer;
  let count = 0;

  for (const num of nums) {
    if (count === 0) {
      answer = num;
    }

    if (num === answer) {
      count++;
    } else {
      count--;
    }
  }

  return answer;
}

