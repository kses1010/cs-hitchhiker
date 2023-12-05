test("test", () => {
  const nums1 = [1, 2, 3, 0, 0, 0];
  const m1 = 3;
  const nums2 = [2, 5, 6];
  const n1 = 3;

  const nums3 = [1];
  const m2 = 1;
  const nums4 = [];
  const n2 = 0;

  const nums5 = [0];
  const m3 = 0;
  const nums6 = [1];
  const n3 = 1;

  expect(merge(nums1, m1, nums2, n1)).toEqual([1, 2, 2, 3, 5, 6]);
  expect(merge(nums3, m2, nums4, n2)).toEqual([1]);
  expect(merge(nums5, m3, nums6, n3)).toEqual([1]);

});

function merge(nums1, m, nums2, n) {
  let nums1Index = m - 1;
  let nums2Index = n - 1;
  let totalIndex = m + n - 1;

  while (nums2Index >= 0) {
    if (nums1Index >= 0 && nums1[nums1Index] > nums2[nums2Index]) {
      nums1[totalIndex] = nums1[nums1Index];
      totalIndex--;
      nums1Index--;
    } else {
      nums1[totalIndex] = nums2[nums2Index];
      totalIndex--;
      nums2Index--;
    }
  }
  return nums1;
}



