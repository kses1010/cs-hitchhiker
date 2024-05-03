test("test", () => {
  const matrix1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
  const output1 = [[7, 4, 1], [8, 5, 2], [9, 6, 3]];

  const matrix2 = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]];
  const output2 = [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]];

  expect(rotate(matrix1)).toEqual(output1);
  expect(rotate(matrix2)).toEqual(output2);
});

function rotate(matrix) {
  const n = matrix.length;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < i; j++) {
      [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
    }
  }

  for (let i = 0; i < n; i++) {
    matrix[i].reverse();
  }

  return matrix;
}
