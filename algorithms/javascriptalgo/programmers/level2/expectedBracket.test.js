test("test", () => {

    expect(solution(8, 4, 7)).toBe(3);
});

function solution2(n, a, b) {
    let answer = 1;
    while (n !== 2) {
        if (a % 2 !== 0) {
            a++;
        }
        if (b % 2 !== 0) {
            b++;
        }
        if (a === b) {
            return answer;
        }
        answer++;
        a = Math.floor(a / 2);
        b = Math.floor(b / 2);
        n = Math.floor(n / 2);
    }
    return answer;
}

function solution(n, a, b) {
    let answer = 0;
    while (a !== b) {
        a = Math.ceil(a / 2);
        b = Math.ceil(b / 2);
        answer++;
    }

    return answer;
}
