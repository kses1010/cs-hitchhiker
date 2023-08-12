test("test", () => {
    let msg1 = "KAKAO";
    let msg2 = "TOBEORNOTTOBEORTOBEORNOT";
    let msg3 = "ABABABABABABABAB";

    expect(solution(msg1)).toEqual([11, 1, 27, 15]);
    expect(solution(msg2)).toEqual([20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]);
    expect(solution(msg3)).toEqual([1, 2, 27, 29, 28, 31, 30]);
});

function solution(msg) {
    let answer = [];
    const dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")
        .reduce((acc, cur, i) => (acc[cur] = i + 1, acc), {});

    let nextWord = "";
    let wordCount = 27;
    const word = msg.split("").reduce((acc, cur) => {
        nextWord = acc + cur;
        if (dict[nextWord] === undefined) {
            dict[nextWord] = wordCount++;
        } else {
            return acc + cur;
        }
        if (dict[acc] !== undefined) {
            answer.push(dict[acc]);
        }
        return cur;
    }, "");

    answer.push(dict[word]);

    return answer;
}
