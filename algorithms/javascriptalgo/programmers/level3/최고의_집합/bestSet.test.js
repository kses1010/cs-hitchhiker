test("test", () => {

    expect(solution(2, 9)).toEqual([4, 5]);
    expect(solution(2, 1)).toEqual([-1]);
    expect(solution(2, 8)).toEqual([4, 4]);
});

function solution(n, s) {
    if (n > s) {
        return [-1];
    }
    let answer = new Array(n).fill(0);
    let num = Math.floor(s / n);
    for (let i = 0; i < n; i++) {
        answer[i] = num;
    }
    let rest = s % n;
    for (let i = 0; i < rest; i++) {
        answer[i]++;
    }

    return answer.sort((a, b) => a - b);
}
