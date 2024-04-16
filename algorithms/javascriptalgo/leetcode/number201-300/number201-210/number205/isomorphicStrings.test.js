test("test", () => {
  const s1 = "egg";
  const t1 = "add";

  const s2 = "foo";
  const t2 = "bar";

  const s3 = "paper";
  const t3 = "title";

  expect(isIsomorphic(s1, t1)).toBeTruthy();
  expect(isIsomorphic(s2, t2)).toBeFalsy();
  expect(isIsomorphic(s3, t3)).toBeTruthy();
});

function isIsomorphic(s, t) {
  for (let i = 0; i < s.length; i++) {
    if (s.indexOf(s[i], i + 1) !== t.indexOf(t[i], i + 1)) {
      return false;
    }
  }
  return true;
}
