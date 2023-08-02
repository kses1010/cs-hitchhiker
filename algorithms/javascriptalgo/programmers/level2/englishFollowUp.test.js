test("test", () => {
    let n1 = 3;
    let words1 = ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"];

    let n2 = 2;
    let words2 = ["hello", "one", "even", "never", "now", "world", "draw"];

    expect(solution(n1, words1)).toEqual([3, 3]);
    expect(solution(n2, words2)).toEqual([1, 3]);
});

function solution(n, words) {
    let answer = [0, 0];
    const wordSet = new Set();
    wordSet.add(words[0]);

    for (let i = 1; i < words.length; i++) {
        let word = words[i];
        let beforeWord = words[i - 1];
        if (!wordSet.has(word) && beforeWord[beforeWord.length - 1] === word[0]) {
            wordSet.add(word);
        } else {
            answer[0] = (i % n) + 1;
            answer[1] = Math.floor((i / n)) + 1;
            return answer;
        }
    }
    return answer;
}
