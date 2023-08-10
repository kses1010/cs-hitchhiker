test("test", () => {
    const priorities1 = [2, 1, 3, 2];
    const location1 = 2;

    const priorities2 = [1, 1, 9, 1, 1, 1];
    const location2 = 0;

    expect(solution(priorities1, location1)).toBe(1);
    expect(solution(priorities2, location2)).toBe(5);
})

function solution(priorities, location) {
    let print = priorities.map((priority, index) => {
        return {
            index: index, priority: priority
        }
    });

    const queue = [];

    while (print.length > 0) {
        let first = print.shift();
        let hasHighPriority = print.some(item => item.priority > first.priority);
        if (hasHighPriority) {
            print.push(first);
        } else {
            queue.push(first.index);
        }
    }

    return queue.findIndex(e => e === location) + 1;
}
