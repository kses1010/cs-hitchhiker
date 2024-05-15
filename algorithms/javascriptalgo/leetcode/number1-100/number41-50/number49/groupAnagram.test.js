test("test", () => {
  const strs1 = ["eat", "tea", "tan", "ate", "nat", "bat"];
  const output1 = [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]];

  const strs2 = [""];
  const output2 = [""];

  const strs3 = ["a"];
  const output3 = ["a"];

  expect(groupAnagrams(strs1)).toEqual(output1);
  expect(groupAnagrams(strs2)).toEqual(output2);
  expect(groupAnagrams(strs3)).toEqual(output3);
});

function groupAnagrams(strs) {
  const map = {};

  for (const str of strs) {
    const s = str.split('').sort().join('');
    if (!map[s]) {
      map[s] = [];
    }
    map[s].push(str);
  }
  return Object.values(map);
}
