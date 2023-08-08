test("test", () => {
    let s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
    let s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
    let s3 = "{{20,111},{111}}";
    let s4 = "{{123}}";
    let s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

    expect(solution(s1)).toEqual([2, 1, 3, 4]);
    expect(solution(s2)).toEqual([2, 1, 3, 4]);
    expect(solution(s3)).toEqual([111, 20]);
    expect(solution(s4)).toEqual([123]);
    expect(solution(s5)).toEqual([3, 2, 4, 1]);
})

function solution(s) {
    const answer = [];
    let tuples = s.slice(2, -2).split(/},{/g).sort((a, b) => a.length - b.length);

    tuples.forEach(v => {
        let tuple = v.split(",");
        answer.push(tuple.find(e => !answer.includes(e)));
    });

    return answer.map(e => Number(e));
}
