test("test", () => {
  const numbers1 = [2, 7, 11, 15];
  const target1 = 9;
  const numbers2 = [2, 3, 4];
  const target2 = 6;
  const numbers3 = [-1, 0];
  const target3 = -1;

  expect(twoSum(numbers1, target1)).toEqual([1, 2]);
  expect(twoSum(numbers2, target2)).toEqual([1, 3]);
  expect(twoSum(numbers3, target3)).toEqual([1, 2]);
});

function twoSum(numbers, target) {
  let start = 0;
  let end = numbers.length - 1;

  while (start < end) {
    let sum = numbers[start] + numbers[end];
    if (sum === target) {
      return [start + 1, end + 1];
    } else if (sum > target) {
      end--;
    } else if (sum < target) {
      start++;
    }
  }
  return 0;
}
