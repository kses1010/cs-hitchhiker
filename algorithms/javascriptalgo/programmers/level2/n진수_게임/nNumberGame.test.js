test("test", () => {
  let n1 = 2;
  let t1 = 4;
  let m1 = 2;
  let p1 = 1;

  let n2 = 16;
  let t2 = 16;
  let m2 = 2;
  let p2 = 1;

  let n3 = 16;
  let t3 = 16;
  let m3 = 2;
  let p3 = 2;

  expect(solution(n1, t1, m1, p1)).toBe("0111");
  expect(solution(n2, t2, m2, p2)).toBe("02468ACE11111111");
  expect(solution(n3, t3, m3, p3)).toBe("13579BDF01234567");
});

function solution(n, t, m, p) {
  let answer = "";
  let nNumber = "";
  for (let i = 0; i < t * m; i++) {
    nNumber += i.toString(n).toUpperCase();
  }
  for (let i = p - 1; i < t * m; i += m) {
    answer += nNumber[i];
  }

  return answer;
}
