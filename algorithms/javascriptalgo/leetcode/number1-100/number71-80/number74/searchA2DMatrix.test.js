test("test", () => {
  const matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]];
  const target1 = 3;
  const target2 = 13;

  expect(searchMatrix(matrix, target1)).toBeTruthy();
  expect(searchMatrix(matrix, target2)).toBeFalsy();
});

function searchMatrix(matrix, target) {
  let row = 0;
  let col = matrix[0].length - 1;

  while (row < matrix.length && col >= 0) {
    if (matrix[row][col] === target) return true;
    if (matrix[row][col] > target) {
      col--;
    } else {
      row++;
    }
  }
  return false;
}
