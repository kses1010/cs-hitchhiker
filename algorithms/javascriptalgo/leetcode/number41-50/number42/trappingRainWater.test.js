test("test", () => {
  const height1 = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1];
  const height2 = [4, 2, 0, 3, 2, 5];

  expect(trap(height1)).toEqual(6);
  expect(trap(height2)).toEqual(9);
});

function trap(height) {
  let answer = 0;

  let length = height.length;
  if (length === 0) {
    return answer;
  }

  let left = 0;
  let right = length - 1;
  let leftMax = height[left];
  let rightMax = height[right];

  while (left < right) {
    leftMax = Math.max(leftMax, height[left]);
    rightMax = Math.max(rightMax, height[right]);

    if (leftMax <= rightMax) {
      answer += leftMax - height[left];
      left++;
    } else {
      answer += rightMax - height[right];
      right--;
    }
  }

  return answer;
}
