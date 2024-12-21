test("test", () => {
  const N1 = 5;
  const stages1 = [2, 1, 2, 6, 2, 4, 3, 3];

  const N2 = 4;
  const stages2 = [4, 4, 4, 4, 4];

  expect(solution(N1, stages1)).toEqual([3, 4, 2, 1, 5]);
  expect(solution(N2, stages2)).toEqual([4, 1, 2, 3]);
});

function solution(N, stages) {
  let result = [];
  for (let i = 1; i <= N; i++) {
    let arrival = stages.filter((x) => x >= i).length; // 해당 스테이지 통과 및 멈춘 수
    let cur = stages.filter((x) => x === i).length; // 해당 스테이지에 머문 수
    result.push([i, cur / arrival]);
  }
  result.sort((a, b) => b[1] - a[1]);
  return result.map((x) => x[0]);
}
