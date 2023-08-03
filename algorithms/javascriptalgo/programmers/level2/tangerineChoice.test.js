test("test", () => {
    let k1 = 6;
    let tangerine1 = [1, 3, 2, 5, 4, 5, 2, 3];

    let k2 = 4;
    let tangerine2 = [1, 3, 2, 5, 4, 5, 2, 3];

    let k3 = 2;
    let tangerine3 = [1, 1, 1, 1, 2, 2, 2, 3];

    expect(solution(k1, tangerine1)).toBe(3);
    expect(solution(k2, tangerine2)).toBe(2);
    expect(solution(k3, tangerine3)).toBe(1);
});

function solution(k, tangerine) {
    let answer = 0;
    const maps = {};
    // 함수형으로 Map으로 ++ 하기
    tangerine.forEach((t) => maps[t] = (maps[t] || 0) + 1);
    const counts = Object.values(maps).sort((a, b) => b - a);
    for (const count of counts) {
        if (k > 0) {
            k -= count;
            answer++;
        } else {
            return answer;
        }
    }

    return answer;
}
