test("test", () => {
  const s1 = "A man, a plan, a canal: Panama";
  const s2 = "race a car";
  const s3 = "  ";

  expect(isPalindrome(s1)).toBeTruthy();
  expect(isPalindrome(s2)).toBeFalsy();
  expect(isPalindrome(s3)).toBeTruthy();
});

function isPalindrome(s) {
  let lowerS = s.toLowerCase().replace(/[^a-z0-9]/gi, '');
  let lt = 0;
  let rt = lowerS.length - 1;
  while (lt < rt) {
    if (lowerS.charAt(lt) !== lowerS.charAt(rt)) return false;
    lt++;
    rt--;
  }
  return true;
}
