test("test", () => {
  const path1 = "/home/";
  const output1 = "/home";

  const path2 = "/home//foo/";
  const output2 = "/home/foo";

  const path3 = "/home/user/Documents/../Pictures";
  const output3 = "/home/user/Pictures";

  const path4 = "/../";
  const output4 = "/";

  const path5 = "/.../a/../b/c/../d/./";
  const output5 = "/.../b/d";

  expect(simplifyPath(path1)).toEqual(output1);
  expect(simplifyPath(path2)).toEqual(output2);
  expect(simplifyPath(path3)).toEqual(output3);
  expect(simplifyPath(path4)).toEqual(output4);
  expect(simplifyPath(path5)).toEqual(output5);
});

function simplifyPath(path) {
  const stack = [];
  const split = path.split('/');

  for (const s of split) {
    if (s === '.' || s === '') continue;
    if (s === '..') {
      stack.pop();
    } else {
      stack.push(s);
    }
  }

  return '/' + stack.join('/');
}
