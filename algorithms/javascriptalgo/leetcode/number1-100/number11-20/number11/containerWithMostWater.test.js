test("test", () => {
  const height1 = [1, 8, 6, 2, 5, 4, 8, 3, 7];
  const height2 = [1, 1];

  expect(maxArea(height1)).toEqual(49);
  expect(maxArea(height2)).toEqual(1);
});

function maxArea(height) {
  let answer = 0;
  let left = 0;
  let right = height.length - 1;

  while (left <= right) {
    let area = (right - left) * Math.min(height[left], height[right]);
    answer = Math.max(answer, area);
    if (height[left] <= height[right]) {
      left++;
    } else {
      right--;
    }
  }

  return answer;
}
