test("test", () => {
  const s1 = "banana";
  const s2 = "abracadabra";
  const s3 = "aaabbaccccabba";

  expect(solution(s1)).toEqual(3);
  expect(solution(s2)).toEqual(6);
  expect(solution(s3)).toEqual(3);
});

function solution(s) {
  let answer = 0;
  let i = 0;

  while (i < s.length) {
    const x = s[i];
    let count = 0;
    let countOther = 0;

    while (i < s.length) {
      if (x === s[i]) {
        count++;
      } else {
        countOther++;
      }
      i++;

      if (count === countOther) break;
    }
    answer++;
  }
  return answer;
}
