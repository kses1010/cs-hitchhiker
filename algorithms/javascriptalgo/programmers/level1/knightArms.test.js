test("test", () => {
    let number1 = 5;
    let limit1 = 3;
    let power1 = 2;

    let number2 = 10;
    let limit2 = 3;
    let power2 = 2;

    expect(solution(number1, limit1, power1)).toBe(10);
    expect(solution(number2, limit2, power2)).toBe(21);
});

function solution(number, limit, power) {
    let answer = 0;
    const knights = new Array(number + 1).fill(0);
    for (let i = 1; i <= number; i++) {
        for (let j = 1; j <= number / i; j++) {
            knights[i * j]++;
        }
    }

    for (let i = 1; i <= number; i++) {
        if (knights[i] <= limit) {
            answer += knights[i];
        } else {
            answer += power;
        }
    }

    return answer;
}
