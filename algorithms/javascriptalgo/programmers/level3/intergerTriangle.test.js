test("test", () => {
    const triangle = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]];

    expect(solution(triangle)).toBe(30);
});

function solution(triangle) {
    let answer = 0;
    if (triangle.length === 1) {
        return triangle[0][0];
    }
    for (let i = 1; i < triangle.length; i++) {
        for (let j = 0; j < triangle[i].length; j++) {
            if (j === 0) {
                triangle[i][j] += triangle[i - 1][j];
            } else if (i === j) {
                triangle[i][j] += triangle[i - 1][j - 1];
            } else {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
            answer = Math.max(answer, triangle[i][j]);
        }
    }

    return answer;
}
