test("test", () => {
  const word1 = "AAAAE";
  const word2 = "AAAE";
  const word3 = "I";
  const word4 = "EIO"

  expect(solution(word1)).toBe(6);
  expect(solution(word2)).toBe(10);
  expect(solution(word3)).toBe(1563);
  expect(solution(word4)).toBe(1189);
});

function solution(word) {
  const init = ["A", "E", "I", "O", "U"];
  const dict = [];

  const dfs = (c, L) => {
    if (L > 5) return;
    dict.push(c);

    for (let i = 0; i < init.length; i++) {
      dfs(c + init[i], L + 1);
    }
  }

  dfs("", 0);

  return dict.indexOf(word);
}
