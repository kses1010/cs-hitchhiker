test("test", () => {
    const progresses1 = [93, 30, 55];
    const speeds1 = [1, 30, 5];

    const progresses2 = [95, 90, 99, 99, 80, 99];
    const speeds2 = [1, 1, 1, 1, 1, 1];

    expect(solution(progresses1, speeds1)).toEqual([2, 1]);
    expect(solution(progresses2, speeds2)).toEqual([1, 3, 2]);
})

function solution(progresses, speeds) {
    if (progresses.length === 1) {
        return [1];
    }
    let answer = [];
    const rest = [];
    for (let i = 0; i < progresses.length; i++) {
        rest.push(Math.ceil((100 - progresses[i]) / speeds[i]));
    }
    let maxProgress = rest[0];
    let count = 0;
    for (let i = 0; i < rest.length; i++) {
        if (rest[i] <= maxProgress) {
            count++;
        } else {
            maxProgress = rest[i];
            answer.push(count);
            count = 1;
        }
        if (i === rest.length - 1) {
            answer.push(count);
        }
    }

    return answer;
}
