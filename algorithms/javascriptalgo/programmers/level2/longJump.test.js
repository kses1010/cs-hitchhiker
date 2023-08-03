test("test", () => {
    let n1 = 4;
    let n2 = 3;

    expect(solution(n1)).toBe(5);
    expect(solution(n2)).toBe(3);
});

function solution(n) {
    let dp = [];
    dp[1] = 1;
    dp[2] = 2;
    for (let i = 3; i <= n; i++) {
        dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
    }

    return dp[n];
}
