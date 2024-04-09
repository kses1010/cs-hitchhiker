test("test", () => {
    let s1 = "one4seveneight";
    let s2 = "23four5six7";
    let s3 = "2three45sixseven";
    let s4 = "123";

    expect(solution(s1)).toBe(1478);
    expect(solution(s2)).toBe(234567);
    expect(solution(s3)).toBe(234567);
    expect(solution(s4)).toBe(123);
});

function solution(s) {
    let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    let answer = s;

    for (let i = 0; i < numbers.length; i++) {
        let arr = answer.split(numbers[i]);
        answer = arr.join(i);
    }

    return Number(answer);
}
