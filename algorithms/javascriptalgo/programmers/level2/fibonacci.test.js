test("test", () => {
    let n1 = 3;
    let n2 = 5;

    expect(solution(n1)).toBe(2)
    expect(solution(n2)).toBe(5)
});


function solution(n) {
    let dp = new Array(n + 1).fill(0)
    dp[1] = 1;
    dp[2] = 1;

    for (let i = 3; i <= n; i++) {
        let sum = dp[i - 2] + dp[i - 1];
        dp[i] = sum % 1234567;
    }
    return dp[n];
}
