test("test", () => {
  const s1 = "one4seveneight";
  const s2 = "23four5six7";
  const s3 = "2three45sixseven";
  const s4 = "123";

  expect(solution(s1)).toEqual(1478);
  expect(solution(s2)).toEqual(234567);
  expect(solution(s3)).toEqual(234567);
  expect(solution(s4)).toEqual(123);
});

function solution(s) {
  const numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];

  for (let i = 0; i < numbers.length; i++) {
    let arr = s.split(numbers[i]);
    s = arr.join(i);
  }

  return Number(s);
}
