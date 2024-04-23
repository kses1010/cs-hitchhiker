test("test", () => {
  const s1 = "anagram";
  const t1 = "nagaram";

  const s2 = "rat";
  const t2 = "car";

  expect(isAnagram(s1, t1)).toBeTruthy();
  expect(isAnagram(s2, t2)).toBeFalsy();
});

function isAnagram(s, t) {
  if(s.length !== t.length) return false;

  let sArr = s.split("").sort();
  let tArr = t.split("").sort();

  for (let i = 0; i < sArr.length; i++) {
    if (sArr[i] !== tArr[i]) {
      return false;
    }
  }

  return true;
}
