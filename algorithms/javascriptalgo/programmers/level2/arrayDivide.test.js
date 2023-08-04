test("test", () => {
    let n1 = 3;
    let left1 = 2;
    let right1 = 5;

    let n2 = 4;
    let left2 = 7;
    let right2 = 14;

    expect(solution(n1, left1, right1)).toEqual([3, 2, 2, 3]);
    expect(solution(n2, left2, right2)).toEqual([4, 3, 3, 3, 4, 4, 4, 4]);
});

function solution(n, left, right) {
    let answer = [];
    for (let i = left; i < right + 1; i++) {
        let row = Math.floor(i / n);
        let col = i % n;
        answer.push(Math.max(row, col) + 1);
    }

    return answer;
}
