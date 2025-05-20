test("test", () => {
  const A1 = [5, 1, 3, 7];
  const B1 = [2, 2, 6, 8];

  const A2 = [2, 2, 2, 2];
  const B2 = [1, 1, 1, 1];

  expect(solution(A1, B1)).toEqual(3);
  expect(solution(A2, B2)).toEqual(0);
});

function solution(A, B) {
  A.sort((a, b) => a - b);
  B.sort((a, b) => a - b);

  let answer = 0;
  let aIndex = 0, bIndex = 0;
  const n = A.length;

  while (aIndex < n && bIndex < n) {
    if (A[aIndex] < B[bIndex]) {
      answer++;
      aIndex++;
      bIndex++;
    } else {
      bIndex++;
    }
  }

  return answer;
}
