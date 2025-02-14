test("test", () => {
  const s1 = "ABAB";
  const k1 = 2;

  const s2 = "AABABBA";
  const k2 = 1;

  expect(characterReplacement(s1, k1)).toEqual(4);
  expect(characterReplacement(s2, k2)).toEqual(4);
});

/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
const characterReplacement = function(s, k) {
  let left = 0;
  let maxCount = 0;
  let answer = 0;
  const alphaCount = Array(26).fill(0);

  for (let right = 0; right < s.length; right++) {
    alphaCount[s.charCodeAt(right) - 65]++;
    maxCount = Math.max(maxCount, alphaCount[s.charCodeAt(right) - 65]);

    while ((right - left + 1) - maxCount > k) {
      alphaCount[s.charCodeAt(left) - 65]--;
      left++;
    }
    answer = Math.max(answer, right - left + 1);
  }
  return answer;
};
