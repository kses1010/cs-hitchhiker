test("test", () => {
    let citations = [3, 0, 6, 1, 5];

    expect(solution(citations)).toBe(3);
});

function solution(citations) {
    citations.sort((a, b) => b - a);
    let count = 0;
    while (count + 1 <= citations[count]) {
        count++;
    }

    return count;
}
