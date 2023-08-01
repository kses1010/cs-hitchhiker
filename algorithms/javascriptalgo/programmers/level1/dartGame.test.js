test("test", () => {
    var dartResult = "1S2D*3T";

    expect(solution(dartResult)).toBe(37);
});

function solution(dartResult) {
    const bonus = {'S': 1, 'D': 2, 'T': 3};
    const options = {'*': 2, '#': -1, undefined: 1}

    let darts = dartResult.match(/\d.?\D/g);

    for (let i = 0; i < darts.length; i++) {
        let split = darts[i].match(/(^\d{1,})(S|D|T)(\*|#)?/);
        let score = Math.pow(split[1], bonus[split[2]]) * options[split[3]];

        if (split[3] === '*' && darts[i - 1]) {
            darts[i - 1] *= options['*'];
        }
        darts[i] = score;
    }

    return darts.reduce((a, b) => a + b);
}
