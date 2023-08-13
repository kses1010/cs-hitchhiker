test("test", () => {
    let n1 = 8;
    let m1 = 4;
    const section1 = [2, 3, 6];

    let n2 = 5;
    let m2 = 4;
    const section2 = [1, 3];

    let n3 = 4;
    let m3 = 1;
    const section3 = [1, 2, 3, 4];

    expect(solution(n1, m1, section1)).toBe(2);
    expect(solution(n2, m2, section2)).toBe(1);
    expect(solution(n3, m3, section3)).toBe(4);
});

function solution(n, m, section) {
    let answer = 1;
    if (n === 1) {
        return answer;
    }
    let left = 0;
    let right = 1;
    while (right < section.length) {
        let range = section[right] - section[left];
        if (range < m) {
            right++;
        } else {
            left = right;
            right = left + 1;
            answer++;
        }
    }

    return answer;
}
