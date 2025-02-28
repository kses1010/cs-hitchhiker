test("test", () => {
  const dartResult1 = "1S2D*3T";
  const dartResult2 = "1D2S#10S";
  const dartResult3 = "1T2D3D#";

  expect(solution(dartResult1)).toEqual(37);
  expect(solution(dartResult2)).toEqual(9);
  expect(solution(dartResult3)).toEqual(-4);
});

function solution(dartResult) {
  const bonus = {'S': 1, 'D': 2, 'T': 3};
  const options = {'*': 2, '#': -1, undefined: 1};
  const total = [];

  let darts = dartResult.match(/\d{1,2}[SDT][*#]?/g);

  for (let i = 0; i < darts.length; i++) {
    let [, score, bonusScore, option] = darts[i].match(/(\d{1,2})([SDT])([*#])?/);
    let totalScore = Math.pow(score, bonus[bonusScore]) * options[option];

    if (option === '*' && total[i - 1]) {
      total[i - 1] *= options['*'];
    }
    total[i] = totalScore;
  }

  return total.reduce((a, b) => a + b);
}
