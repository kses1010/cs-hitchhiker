test("test", () => {
  const board1 = [
    ["5", "3", ".", ".", "7", ".", ".", ".", "."],
    ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    [".", "9", "8", ".", ".", ".", ".", "6", "."],
    ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    [".", "6", ".", ".", ".", ".", "2", "8", "."],
    [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    [".", ".", ".", ".", "8", ".", ".", "7", "9"]
  ];

  const board2 = [
    ["8", "3", ".", ".", "7", ".", ".", ".", "."],
    ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    [".", "9", "8", ".", ".", ".", ".", "6", "."],
    ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    [".", "6", ".", ".", ".", ".", "2", "8", "."],
    [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    [".", ".", ".", ".", "8", ".", ".", "7", "9"]
  ];

  const board3 = [
    [".", ".", ".", ".", "5", ".", ".", "1", "."],
    [".", "4", ".", "3", ".", ".", ".", ".", "."],
    [".", ".", ".", ".", ".", "3", ".", ".", "1"],
    ["8", ".", ".", ".", ".", ".", ".", "2", "."],
    [".", ".", "2", ".", "7", ".", ".", ".", "."],
    [".", "1", "5", ".", ".", ".", ".", ".", "."],
    [".", ".", ".", ".", ".", "2", ".", ".", "."],
    [".", "2", ".", "9", ".", ".", ".", ".", "."],
    [".", ".", "4", ".", ".", ".", ".", ".", "."]
  ];

  // expect(isValidSudoku(board1)).toBeTruthy();
  // expect(isValidSudoku(board2)).toBeFalsy();
  expect(isValidSudoku(board3)).toBeFalsy();
});

function isValidSudoku(board) {
  const pattern = /\d/;
  const set = new Set();
  // 가로
  for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
      let element = board[i][j];
      if (pattern.test(element)) {
        if (set.has(element)) {
          return false;
        }
        set.add(element);
      }
    }
    set.clear();
  }

  // 세로
  for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
      let element = board[j][i];
      if (pattern.test(element)) {
        if (set.has(element)) {
          return false;
        }
      }
      set.add(element);
    }
    set.clear();
  }

  // Grid
  let top = 0;
  let bot = 2;
  let left = 0;
  let right = 2;

  const isValidGrid = (top, bot, left, right) => {
    // 작은 박스
    for (let i = top; i <= bot; i++) {
      for (let j = left; j <= right; j++) {
        let element = board[i][j];
        if (pattern.test(element)) {
          if (set.has(element)) {
            return false;
          }
        }
        set.add(element);
      }
    }
    set.clear();
    return true;
  }

  while (bot < 9) {
    if (right < 9) {
      if (!isValidGrid(top, bot, left, right)) return false;
      left += 3;
      right += 3;
    } else {
      left = 0;
      right = 2;
      top += 3;
      bot += 3;
      if (bot < 9) {
        if (!isValidGrid(top, bot, left, right)) return false;
      }
    }
  }

  return true;
}

