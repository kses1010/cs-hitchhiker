test("test", () => {
  const s1 = "()";
  const s2 = "(){}[]";
  const s3 = "(]";

  expect(isValid(s1)).toBeTruthy();
  expect(isValid(s2)).toBeTruthy();
  expect(isValid(s3)).toBeFalsy();
});

function isValid(s) {
  const dict = {
    ")": "(",
    "}": "{",
    "]": "["
  };

  const stack = [];
  for (let i = 0; i < s.length; i++) {
    const c = s[i];
    if (dict[c] === undefined) {
      stack.push(c);
    } else if (stack.length === 0 || dict[c] !== stack.pop()) {
      return false;
    }
  }
  return stack.length === 0;
}
