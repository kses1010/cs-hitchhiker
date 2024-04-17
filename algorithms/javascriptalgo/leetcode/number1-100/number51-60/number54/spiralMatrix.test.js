test("test", () => {
  const matrix1 = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
  ];
  const matrix2 = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12]
  ];

  expect(spiralOrder(matrix1)).toEqual([1, 2, 3, 6, 9, 8, 7, 4, 5]);
  expect(spiralOrder(matrix2)).toEqual([1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]);
});

function spiralOrder(matrix) {
  const answer = [];
  const m = matrix.length;
  const n = matrix[0].length;

  let topRow = 0;
  let botRow = m - 1;
  let leftCol = 0;
  let rightCol = n - 1;

  while (topRow <= botRow && leftCol <= rightCol) {
    // 오른쪽
    for (let i = leftCol; i <= rightCol; i++) {
      answer.push(matrix[topRow][i]);
    }
    topRow++;

    // 아래
    for (let i = topRow; i <= botRow; i++) {
      answer.push(matrix[i][rightCol]);
    }
    rightCol--;

    // 왼쪽
    if (topRow <= botRow) {
      for (let i = rightCol; i >= leftCol; i--) {
        answer.push(matrix[botRow][i]);
      }
      botRow--;
    }

    // 위
    if (leftCol <= rightCol) {
      for (let i = botRow; i >= topRow; i--) {
        answer.push(matrix[i][leftCol]);
      }
      leftCol++;
    }
  }

  return answer;
}
