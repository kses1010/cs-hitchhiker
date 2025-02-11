test("test", () => {
  const nums1 = [1, 3];
  const nums2 = [2];

  const nums3 = [1, 2];
  const nums4 = [3, 4];

  expect(findMedianSortedArrays(nums1, nums2)).toEqual(2.0);
  expect(findMedianSortedArrays(nums3, nums4)).toEqual(2.5);
});

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
const findMedianSortedArrays = function(nums1, nums2) {
  if (nums1.length > nums2.length) {
    [nums1, nums2] = [nums2, nums1];
  }

  const m = nums1.length;
  const n = nums2.length;
  let low = 0
  let high = m;

  while (low <= high) {
    // 분할 인덱스 계산하기
    const partition1 = Math.floor((low + high) / 2);
    const partition2 = Math.floor((m + n + 1) / 2) - partition1;

    // 분할의 경계값 설정하기
    const maxLeft1 = (partition1 === 0) ? -Infinity : nums1[partition1 - 1];
    const minRight1 = (partition1 === m) ? Infinity : nums1[partition1];

    const maxLeft2 = (partition2 === 0) ? -Infinity : nums2[partition2 - 1];
    const minRight2 = (partition2 === n) ? Infinity : nums2[partition2];

    // 분할 조건 검사하기
    if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
      if ((m + n) % 2 === 0) {
        return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
      } else {
        return Math.max(maxLeft1, maxLeft2);
      }
      //
    } else if (maxLeft1 > minRight2) {
      high = partition1 - 1;
    } else {
      low = partition1 + 1;
    }
  }
};
