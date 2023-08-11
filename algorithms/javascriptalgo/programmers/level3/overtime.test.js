test("test", () => {
    let n1 = 4;
    const works1 = [4, 3, 3];

    let n2 = 1;
    const works2 = [2, 1, 2];

    let n3 = 3;
    const works3 = [1, 1];

    expect(solution(n1, works1)).toBe(12);
    expect(solution(n2, works2)).toBe(6);
    expect(solution(n3, works3)).toBe(0);
});

function solution(n, works) {
    if (n >= works.reduce((acc, cur) => acc + cur, 0)) {
        return 0;
    }
    works.sort((a, b) => b - a);
    while (n !== 0) {
        let max = works[0];
        for (let i = 0; i < works.length; i++) {
            if (works[i] >= max) {
                n--;
                works[i]--;
            }
            if (n === 0) {
                break;
            }
        }
    }

    return works.reduce((acc, cur) => acc + cur ** 2, 0);
}
