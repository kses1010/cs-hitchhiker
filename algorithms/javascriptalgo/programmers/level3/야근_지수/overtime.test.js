test("test", () => {
  let n1 = 4;
  const works1 = [4, 3, 3];

  let n2 = 1;
  const works2 = [2, 1, 2];

  let n3 = 3;
  const works3 = [1, 1];

  expect(solution(n1, works1)).toEqual(12);
  expect(solution(n2, works2)).toEqual(6);
  expect(solution(n3, works3)).toEqual(0);
});

function solution(n, works) {
  if (n >= works.reduce((acc, cur) => acc + cur, 0)) {
    return 0;
  }
  works.sort((a, b) => b - a);
  while (n !== 0) {
    let max = works[0];
    for (let i = 0; i < works.length; i++) {
      if (works[i] >= max) {
        n--;
        works[i]--;
      }
      if (n === 0) {
        break;
      }
    }
  }

  return works.reduce((acc, cur) => acc + cur ** 2, 0);
}

const sol = (n, works) => {
  const totalWork = works.reduce((acc, cur) => acc + cur, 0);
  if (totalWork <= n) return 0;

  for (let i = 0; i < n; i++) {
    works.sort((a, b) => b - a);
    works[0] = Math.max(works[0] - 1, 0);
  }

  return works.reduce((acc, cur) => acc + cur * cur, 0);
}
