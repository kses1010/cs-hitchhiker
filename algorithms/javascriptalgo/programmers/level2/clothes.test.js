test("test", () => {
    const clothes1 = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]];
    const clothes2 = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]];

    expect(solution(clothes1)).toBe(5);
    expect(solution(clothes2)).toBe(3);
})

function solution(clothes) {
    let answer = 1;
    const map = {};
    clothes.forEach(item => {
        let name = item[1];
        map[name] = (map[name] || 0) + 1;
    });

    for (let key in map) {
        answer *= (map[key] + 1);
    }

    return answer - 1;
}
