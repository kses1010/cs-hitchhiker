test("test", () => {
  const matrix1 = [[1, 1, 1], [1, 0, 1], [1, 1, 1]];
  const output1 = [[1, 0, 1], [0, 0, 0], [1, 0, 1]];

  const matrix2 = [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]];
  const output2 = [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]];

  expect(setZeroes(matrix1)).toEqual(output1);
  expect(setZeroes(matrix2)).toEqual(output2);
});

function setZeroes(matrix) {
  const n = matrix.length;
  const m = matrix[0].length;

  let rowFlag = false;
  let colFlag = false;

  for (let i = 0; i < n; i++) {
    if (matrix[i][0] === 0) {
      colFlag = true;
      break;
    }
  }

  for (let i = 0; i < m; i++) {
    if (matrix[0][i] === 0) {
      rowFlag = true;
      break;
    }
  }

  for (let i = 1; i < n; i++) {
    for (let j = 1; j < m; j++) {
      if (matrix[i][j] === 0) {
        matrix[i][0] = 0;
        matrix[0][j] = 0;
      }
    }
  }

  for (let i = 1; i < n; i++) {
    for (let j = 1; j < m; j++) {
      if (matrix[i][0] === 0 || matrix[0][j] === 0) {
        matrix[i][j] = 0;
      }
    }
  }

  if (colFlag) {
    for (let i = 0; i < n; i++) {
      matrix[i][0] = 0;
    }
  }

  if (rowFlag) {
    for (let i = 0; i < m; i++) {
      matrix[0][i] = 0;
    }
  }

  return matrix;
}
