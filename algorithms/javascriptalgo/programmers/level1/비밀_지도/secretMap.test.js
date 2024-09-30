test("test", () => {
  const n1 = 5;
  const arr1 = [9, 20, 28, 18, 11];
  const arr2 = [30, 1, 21, 17, 28];
  const output1 = ["#####", "# # #", "### #", "#  ##", "#####"];

  const n2 = 6;
  const arr3 = [46, 33, 33, 22, 31, 50];
  const arr4 = [27, 56, 19, 14, 14, 10];
  const output2 = ["######", "###  #", "##  ##", " #### ", " #####", "### # "];

  expect(solution(n1, arr1, arr2)).toEqual(output1);
  expect(solution(n2, arr3, arr4)).toEqual(output2);
});

function solution(n, arr1, arr2) {
  const answer = [];
  for (let i = 0; i < n; i++) {
    let secret = (arr1[i] | arr2[i]).toString(2);
    while (secret.length < n) {
      secret = "0" + secret;
    }
    secret = secret.replaceAll("1", "#").replaceAll("0", " ");
    answer.push(secret);
  }

  return answer;
}
