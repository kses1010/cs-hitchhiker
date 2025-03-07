test("test", () => {
  const lottos1 = [44, 1, 0, 0, 31, 25];
  const win_nums1 = [31, 10, 45, 1, 6, 19];

  const lottos2 = [0, 0, 0, 0, 0, 0];
  const win_nums2 = [38, 19, 20, 40, 15, 25];

  const lottos3 = [45, 4, 35, 20, 3, 9];
  const win_nums3 = [20, 9, 3, 45, 4, 35];

  expect(solution(lottos1, win_nums1)).toEqual([3, 5]);
  expect(solution(lottos2, win_nums2)).toEqual([1, 6]);
  expect(solution(lottos3, win_nums3)).toEqual([1, 1]);
});

function solution(lottos, win_nums) {
  const board = {
    6: 1,
    5: 2,
    4: 3,
    3: 4,
    2: 5,
    1: 6,
    0: 6
  }

  const winSet = new Set(win_nums);

  let zeroCount = 0;
  let winCount = 0;

  for (const num of lottos) {
    if (num === 0) {
      zeroCount++;
    } else if (winSet.has(num)) {
      winCount++;
    }
  }

  return [board[zeroCount + winCount], board[winCount]];
}
