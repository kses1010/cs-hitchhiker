test("test", () => {
    const operations1 = ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"];
    const operations2 = ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]

    expect(solution(operations1)).toEqual([0, 0]);
    expect(solution(operations2)).toEqual([333, -45]);
});

function solution(operations) {
    let list = [];
    operations.forEach(item => {
        let split = item.split(" ");
        if (split[0] === "I") {
            list.push(Number(split[1]));
        } else {
            if (list.length === 0) {
                return;
            }
            let num = split[1];
            let value = (num[0] === "-" ? Math.min : Math.max)(...list);
            let deleteIndex = list.findIndex(e => e === value);

            list.splice(deleteIndex, 1);
        }
    })

    if (list.length === 0) {
        return [0, 0];
    }
    return [Math.max(...list), Math.min(...list)];
}

