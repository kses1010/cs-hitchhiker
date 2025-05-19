test("test", () => {
  const s = "aukks";
  const skip = "wbqd";
  const index = 5;

  expect(solution(s, skip, index)).toEqual("happy");
});

function solution(s, skip, index) {
  const skipSet = new Set(skip);
  const alphaArr = [];
  for (let c = 0; c < 26; c++) {
    const ch = String.fromCharCode(97 + c);
    if (!skipSet.has(ch)) {
      alphaArr.push(ch);
    }
  }
  const length = alphaArr.length;
  let answer = "";
  for (const c of s) {
    const pos = alphaArr.indexOf(c);
    const newPos = (pos + index) % length;
    answer += alphaArr[newPos];
  }

  return answer;
}
