test("test", () => {
    let n1 = 78;
    let n2 = 15;

    expect(solution(n1)).toBe(83);
    expect(solution(n2)).toBe(23);
});

function solution(n) {
    let answer = 0;
    let bitNumCount = bitCount(n.toString(2));
    for (let i = n + 1; i <= 1000000; i++) {
        let tempBitCount = bitCount(i.toString(2));
        if (bitNumCount === tempBitCount) {
            return i;
        }
    }

    return answer;
}

function bitCount(n) {
    let count = 0;
    for (let i = 0; i < n.length; i++) {
        if (n[i] === '1') {
            count++;
        }
    }
    return count;
}


