test("test", () => {
  const s1 = "110010101001";
  const s2 = "01110";
  const s3 = "1111111";

  expect(solution(s1)).toEqual([3, 8]);
  expect(solution(s2)).toEqual([3, 3]);
  expect(solution(s3)).toEqual([4, 1]);
});

function solution(s) {
  let answer = [0, 0];
  while (s.length > 1) {
    let oneCount = 0;
    for (let i = 0; i < s.length; i++) {
      if (s[i] === '0') {
        answer[1]++;
      } else {
        oneCount++;
      }
    }
    s = oneCount.toString(2);
    answer[0]++;
  }

  return answer;
}
