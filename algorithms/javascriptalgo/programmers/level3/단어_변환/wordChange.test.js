test("test", () => {
  const begin = "hit";
  const target = "cog";
  const words1 = ["hot", "dot", "dog", "lot", "log", "cog"];
  const words2 = ["hot", "dot", "dog", "lot", "log"];

  expect(solution(begin, target, words1)).toBe(4);
  expect(solution(begin, target, words2)).toBe(0);
});

function solution(begin, target, words) {
  if (!words.includes(target)) return 0;

  const visited = new Array(words.length).fill(false);
  const q = [[begin, 0]];

  const isDiffOne = (word1, word2) => {
    let diff = 0;
    for (let i = 0; i < word1.length; i++) {
      if (word1[i] !== word2[i]) diff++;
    }
    return diff === 1;
  }

  while (q.length !== 0) {
    const [word, count] = q.shift();
    if (word === target) return count;

    for (let i = 0; i < words.length; i++) {
      if (!visited[i] && isDiffOne(word, words[i])) {
        visited[i] = true;
        q.push([words[i], count + 1]);
      }
    }
  }

  return 0;
}
