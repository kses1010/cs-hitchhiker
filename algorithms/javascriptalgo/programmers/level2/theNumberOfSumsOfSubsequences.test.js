test("test", () => {
    let elements = [7, 9, 1, 1, 4];

    expect(solution(elements)).toBe(18);
});

function solution(elements) {
    let answer = new Set();
    let length = elements.length;
    for (let size = 1; size <= length; size++) {
        for (let i = 0; i < length; i++) {
            let sum = 0;
            for (let j = i; j < i + size; j++) {
                sum += elements[j % length];
            }
            answer.add(sum);
        }
    }

    return answer.size;
}
