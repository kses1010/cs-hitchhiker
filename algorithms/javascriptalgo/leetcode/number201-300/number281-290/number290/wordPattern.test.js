test("test", () => {
  const pattern1 = "abba";
  const s1 = "dog cat cat dog";

  const pattern2 = "abba";
  const s2 = "dog cat cat fish";

  const pattern3 = "aaaa";
  const s3 = "dog cat cat dog";

  expect(wordPattern(pattern1, s1)).toBeTruthy();
  expect(wordPattern(pattern2, s2)).toBeFalsy();
  expect(wordPattern(pattern3, s3)).toBeFalsy();
});

function wordPattern(pattern, s) {
  const words = s.split(" ");
  if (words.length !== pattern.length) return false;
  if (new Set(words).size !== new Set(pattern).size) return false;

  const maps = new Map();
  for (let i = 0; i < words.length; i++) {
    if (maps.has(pattern[i]) && maps.get(pattern[i]) !== words[i]) {
      return false;
    }
    maps.set(pattern[i], words[i]);
  }
  return true;
}
