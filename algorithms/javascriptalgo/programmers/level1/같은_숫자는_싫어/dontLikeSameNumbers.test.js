test("test", () => {
  const arr1 = [1, 1, 3, 3, 0, 1, 1];
  const arr2 = [4, 4, 4, 3, 3];

  expect(solution(arr1)).toEqual([1, 3, 0, 1]);
  expect(solution(arr2)).toEqual([4, 3]);
});

function solution(arr) {
  const answer = [];
  let beforeNum = -1;

  for (let i = 0; i < arr.length; i++) {
    let num = arr[i];
    if (num !== beforeNum) {
      answer.push(num);
    }

    beforeNum = num;
  }

  return answer;
}
