test("test", () => {
    let s1 = "()()";
    let s2 = "(())()";
    let s3 = ")()(";
    let s4 = "(()("

    expect(solution(s1)).toBeTruthy()
    expect(solution(s2)).toBeTruthy()
    expect(solution(s3)).toBeFalsy()
    expect(solution(s4)).toBeFalsy()
});

function solution(s) {
    let stackCount = 0;
    for (let i = 0; i < s.length; i++) {
        let bracket = s[i] === '(' ? 1 : -1;
        stackCount += bracket;
        if (stackCount < 0) {
            return false;
        }
    }

    return stackCount === 0;
}
