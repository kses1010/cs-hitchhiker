test("test", () => {
    const arr1 = [2, 6, 8, 14];
    const arr2 = [1, 2, 3];

    expect(solution(arr1)).toBe(168);
    expect(solution(arr2)).toBe(6);
    expect(solution2(arr1)).toBe(168);
});

function solution(arr) {
    if (arr.length === 1) {
        return arr[0];
    }
    arr.sort();

    let gcd = makeGcd(arr[0], arr[1]);
    let lcm = (arr[0] * arr[1]) / gcd;

    for (let i = 2; i < arr.length; i++) {
        gcd = makeGcd(lcm, arr[i]);
        lcm = (lcm * arr[i]) / gcd;
    }
    return lcm;
}

function makeGcd(a, b) {
    if (a % b === 0) {
        return b;
    }
    return makeGcd(b, a % b);
}

function solution2(arr) {
    return arr.reduce((a, b) => a * b / gcd2(a, b));
}

function gcd2(a, b) {
    return a % b === 0 ? b : gcd2(b, a % b);
}
