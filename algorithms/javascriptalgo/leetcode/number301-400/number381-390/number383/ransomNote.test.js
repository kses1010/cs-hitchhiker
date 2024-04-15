test("test", () => {
  const ransomNote1 = "a";
  const magazine1 = "b";
  const ransomNote2 = "aa";
  const magazine2 = "bb";
  const ransomNote3 = "aa";
  const magazine3 = "aab";

  expect(canConstruct(ransomNote1, magazine1)).toBeFalsy();
  expect(canConstruct(ransomNote2, magazine2)).toBeFalsy();
  expect(canConstruct(ransomNote3, magazine3)).toBeTruthy();
});

function canConstruct(ransomNote, magazine) {
  const map = {};
  for (let i = 0; i < magazine.length; i++) {
    map[magazine[i]] = map[magazine[i]] + 1 || 1;
  }
  for (let i = 0; i < ransomNote.length; i++) {
    if (map[ransomNote[i]] === undefined) {
      return false;
    }
    map[ransomNote[i]] = map[ransomNote[i]] - 1;
    if (map[ransomNote[i]] < 0) {
      return false;
    }
  }

  return true;
}
