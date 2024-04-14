test("test", () => {
  const s1 = "abcabcbb";
  const s2 = "bbbbb";
  const s3 = "pwwkew";

  expect(lengthOfLongestSubstring(s1)).toEqual(3);
  expect(lengthOfLongestSubstring(s2)).toEqual(1);
  expect(lengthOfLongestSubstring(s3)).toEqual(3);
});

function lengthOfLongestSubstring(s) {
  if (s.length === 0) return 0;
  if (s.length === 1) return 1;

  let answer = 0;
  let left = 0;
  const set = new Set();

  for (let i = 0; i < s.length; i++) {
    let c = s[i];
    while (set.has(c)) {
      set.delete(s[left]);
      left++;
    }
    set.add(c);
    answer = Math.max(answer, i - left + 1);
  }

  return answer;
}
