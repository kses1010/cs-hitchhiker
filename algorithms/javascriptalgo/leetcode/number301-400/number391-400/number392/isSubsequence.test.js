test("test", () => {
  const s1 = "abc";
  const t1 = "ahbgdc";
  const s2 = "axc";
  const t2 = "ahbgdc";

  expect(isSubsequence(s1, t1)).toBeTruthy();
  expect(isSubsequence(s2, t2)).toBeFalsy();
});

function isSubsequence(s, t) {
  if (s.length > t.length) return false;
  let sP = 0;
  let tP = 0;

  while (sP < s.length && tP < t.length) {
    if (s.charAt(sP) === t.charAt(tP)) {
      sP++;
      tP++;
    } else {
      tP++;
    }
  }
  return sP === s.length;
}
