test("test", () => {
    var s1 = "one4seveneight";
    var s2 = "23four5six7";
    var s3 = "2three45sixseven";
    var s4 = "123";

    expect(solution(s1)).toBe(1478);
    expect(solution(s2)).toBe(234567);
    expect(solution(s3)).toBe(234567);
    expect(solution(s4)).toBe(123);
});

function solution(s) {
    let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    var answer = s;

    for (var i = 0; i < numbers.length; i++) {
        var arr = answer.split(numbers[i]);
        answer = arr.join(i);
    }

    return Number(answer);
}
