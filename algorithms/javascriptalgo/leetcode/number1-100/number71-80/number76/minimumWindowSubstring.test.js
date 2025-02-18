test("test", () => {
  const s1 = "ADOBECODEBANC";
  const t1 = "ABC";

  const s2 = "a";
  const t2 = "a";

  const s3 = "a";
  const t3 = "aa";

  expect(minWindow(s1, t1)).toEqual("BANC");
  expect(minWindow(s2, t2)).toEqual("a");
  expect(minWindow(s3, t3)).toEqual("");
});

/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
const minWindow = function(s, t) {
  if (t.length > s.length) return "";

  const tMap = {};
  for (const c of t) {
    tMap[c] = (tMap[c] || 0) + 1;
  }

  const required = Object.keys(tMap).length;

  let left = 0;
  let right = 0;
  let satisfy = 0;
  const windowCounts = {};

  let window = [Infinity, null, null];

  while (right < s.length) {
    const char = s[right];
    windowCounts[char] = (windowCounts[char] || 0) + 1;

    if (tMap[char] !== undefined && windowCounts[char] === tMap[char]) {
      satisfy++;
    }

    while (left <= right && satisfy === required) {
      const leftChar = s[left];

      if (right - left + 1 < window[0]) {
        window = [right - left + 1, left, right];
      }

      left++;
      windowCounts[leftChar]--;
      if (tMap[leftChar] !== undefined && windowCounts[leftChar] < tMap[leftChar]) {
        satisfy--;
      }
    }
    right++;
  }

  return window[0] === Infinity ? "" : s.substring(window[1], window[2] + 1);
};
