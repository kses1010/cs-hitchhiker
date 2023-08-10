test("test", () => {
    const k = 80;
    const dungeons = [[80, 20], [50, 40], [30, 10]];

    expect(solution(k, dungeons)).toBe(3);
})

function solution(k, dungeons) {
    let answer = 0;
    let visited = new Array(dungeons.length).fill(false);

    function dfs(L, k, dungeons) {
        for (let i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(L + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
            answer = Math.max(answer, L);
        }
    }

    dfs(0, k, dungeons);

    return answer;
}
