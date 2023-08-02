test("test", () => {
    let brown1 = 10;
    let yellow1 = 2;

    let brown2 = 8;
    let yellow2 = 1;

    let brown3 = 24;
    let yellow3 = 24;

    expect(solution(brown1, yellow1)).toEqual([4, 3]);
    expect(solution(brown2, yellow2)).toEqual([3, 3]);
    expect(solution(brown3, yellow3)).toEqual([8, 6]);
});

function solution(brown, yellow) {
    let answer = [];
    let sum = brown + yellow;

    for (let height = 3; height <= brown; height++) {
        if (sum % height === 0) {
            let weight = sum / height;

            if ((height - 2) * (weight - 2) === yellow) {
                return [weight, height];
            }
        }
    }

    return answer;
}
