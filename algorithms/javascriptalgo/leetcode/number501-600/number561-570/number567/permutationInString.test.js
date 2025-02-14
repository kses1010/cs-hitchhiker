test("test", () => {
  const s1 = "ab";
  const s2 = "eidbaooo";

  const s3 = "ab";
  const s4 = "eidboaoo";

  expect(checkInclusion(s1, s2)).toBeTruthy();
  expect(checkInclusion(s3, s4)).toBeFalsy();
  expect(checkInclusion("a", "ab")).toBeTruthy();
});

/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
const checkInclusion = function(s1, s2) {
  if (s1.length > s2.length) return false;

  const countArr1 = Array(26).fill(0);
  const countArr2 = Array(26).fill(0);
  const aCode = 97;

  for (let i = 0; i < s1.length; i++) {
    countArr1[s1.charCodeAt(i) - aCode]++
    countArr2[s2.charCodeAt(i) - aCode]++
  }

  const isMatch = () => {
    for (let i = 0; i < 26; i++) {
      if (countArr1[i] !== countArr2[i]) return false;
    }
    return true;
  }

  if (isMatch()) return true;

  for (let i = s1.length; i < s2.length; i++) {
    countArr2[s2.charCodeAt(i) - aCode]++;
    countArr2[s2.charCodeAt(i - s1.length) - aCode]--;

    if (isMatch()) return true;
  }

  return false;
};
