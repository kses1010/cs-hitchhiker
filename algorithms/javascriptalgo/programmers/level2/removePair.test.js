test("test", () => {
    let s1 = "baabaa";
    let s2 = "cdcd";

    expect(solution(s1)).toBe(1);
    expect(solution(s2)).toBe(0);
});

function solution(s) {
    const stack = [];
    for (let i = 0; i < s.length; i++) {
        let c = s[i];
        if (stack.length !== 0 && stack[stack.length - 1] === c) {
            stack.pop();
        } else {
            stack.push(c);
        }
    }

    return stack.length === 0 ? 1 : 0;
}
