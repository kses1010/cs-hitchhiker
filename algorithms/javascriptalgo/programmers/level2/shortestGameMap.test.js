test("test", () => {
    let maps1 = [
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1],
        [1, 0, 1, 1, 1],
        [1, 1, 1, 0, 1],
        [0, 0, 0, 0, 1]
    ];

    let maps2 = [
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1],
        [1, 0, 1, 1, 1],
        [1, 1, 1, 0, 0],
        [0, 0, 0, 0, 1]
    ];

    expect(solution(maps1)).toBe(11);
    expect(solution(maps2)).toBe(-1);
});

function solution(maps) {
    let answer = 1;
    let q = [];
    let visited = maps;
    let dx = [-1, 0, 1, 0];
    let dy = [0, -1, 0, 1];
    let n = maps.length;
    let m = maps[0].length;

    q.unshift([0, 0]);
    visited[0][0] = 0;

    while (q.length !== 0) {
        let size = q.length;

        for (let i = 0; i < size; i++) {
            let [x, y] = q.pop();
            for (let j = 0; j < 4; j++) {
                let nx = x + dx[j];
                let ny = y + dy[j];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] === 1) {
                    if (nx === n - 1 && ny === m - 1) {
                        return answer + 1;
                    }
                    q.unshift([nx, ny]);
                    visited[nx][ny] = 0;
                }
            }
        }
        answer++;
    }

    return -1;
}
