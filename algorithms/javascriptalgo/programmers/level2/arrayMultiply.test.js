test("test", () => {
    let arr1 = [[1, 4], [3, 2], [4, 1]];
    let arr2 = [[3, 3], [3, 3]];

    let arr3 = [[2, 3, 2], [4, 2, 4], [3, 1, 4]];
    let arr4 = [[5, 4, 3], [2, 4, 1], [3, 1, 1]];

    expect(solution(arr1, arr2)).toEqual([[15, 15], [15, 15], [15, 15]]);
    expect(solution(arr3, arr4)).toEqual([[22, 22, 11], [36, 28, 18], [29, 20, 14]]);
    expect(solution2(arr1, arr2)).toEqual([[15, 15], [15, 15], [15, 15]]);
    expect(solution2(arr3, arr4)).toEqual([[22, 22, 11], [36, 28, 18], [29, 20, 14]]);
});

function solution(arr1, arr2) {
    const answer = [];
    for (let i = 0; i < arr1.length; i++) {
        const row = [];
        for (let j = 0; j < arr2[0].length; j++) {
            let sum = 0;
            for (let k = 0; k < arr2.length; k++) {
                sum += arr1[i][k] * arr2[k][j];
            }
            row.push(sum);
        }
        answer.push(row);
    }
    return answer;
}

// reduce 활용
function solution2(arr1, arr2) {
    return arr1.map((row) =>
        arr2[0].map((x, y) =>
            row.reduce((a, b, c) => a + (b * arr2[c][y]), 0))
    );
}
