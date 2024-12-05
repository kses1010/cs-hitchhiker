test("test", () => {
  const str1 = "FRANCE";
  const str2 = "french";

  const str3 = "handshake";
  const str4 = "shake hands";

  const str5 = "aa1+aa2";
  const str6 = "AAAA12";

  const str7 = "E=M*C^2";
  const str8 = "e=m*c^2";

  expect(solution(str1, str2)).toBe(16384);
  expect(solution(str3, str4)).toBe(65536);
  expect(solution(str5, str6)).toBe(43690);
  expect(solution(str7, str8)).toBe(65536);
})

function solution(str1, str2) {
  const makeWord = (str) => {
    const arr = [];
    str = str.toLowerCase();
    // 정규표현식으로 영문자로만 이루어진 문자열
    const regEx = /^[a-zA-Z]+$/;
    for (let i = 0; i < str.length - 1; i++) {
      let subStr = str.substring(i, i + 2);
      if (regEx.test(subStr)) {
        arr.push(subStr);
      }
    }
    return arr;
  }

  const arr1 = makeWord(str1);
  const arr2 = makeWord(str2);

  const set = new Set([...arr1, ...arr2]);
  let union = 0;
  let intersection = 0;

  set.forEach(item => {
    const hasSize1 = arr1.filter(x => x === item).length;
    const hasSize2 = arr2.filter(x => x === item).length;
    union += Math.max(hasSize1, hasSize2);
    intersection += Math.min(hasSize1, hasSize2);
  });
  if (union === 0) {
    return 65536;
  }
  return Math.floor(intersection / union * 65536);
}
