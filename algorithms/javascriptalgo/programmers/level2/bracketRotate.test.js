test("test", () => {
    let s1 = "[](){}";
    let s2 = "}]()[{";
    let s3 = "[)(]";
    let s4 = "}}}";

    expect(solution(s1)).toBe(3);
    expect(solution(s2)).toBe(2);
    expect(solution(s3)).toBe(0);
    expect(solution(s4)).toBe(0);
});

function solution(s) {
    let answer = 0;
    s = s.split('');
    for (let i = 0; i < s.length; i++) {
        if (isRightBracket(s)) {
            answer++;
        }
        s.push(s.shift());
    }

    return answer;
}

function isRightBracket(s) {
    const stack = [];
    const maps = new Map();
    maps.set(")", "(");
    maps.set("}", "{");
    maps.set("]", "[");

    for (let i = 0; i < s.length; i++) {
        let c = s[i];
        if (!maps.has(c)) {
            stack.push(c);
        } else if (stack.length === 0 || maps.get(c) !== stack.pop()) {
            return false;
        }
    }
    return stack.length === 0;
}
