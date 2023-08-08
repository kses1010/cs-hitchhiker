test("test", () => {
    const want1 = ["banana", "apple", "rice", "pork", "pot"];
    const number1 = [3, 2, 2, 2, 1];
    const discount1 = ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
        "pot", "banana", "apple", "banana"];

    const want2 = ["apple"];
    const number2 = [10];
    const discount2 = ["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
        "banana"];

    expect(solution(want1, number1, discount1)).toBe(3);
    expect(solution(want2, number2, discount2)).toBe(0);
})

function solution(want, number, discount) {
    let answer = 0;
    for (let i = 0; i < discount.length - 9; i++) {
        const slice = discount.slice(i, i + 10);

        let flag = true;
        for (let j = 0; j < want.length; j++) {
            const wants = slice.filter(item => item === want[j]);
            if (wants.length !== number[j]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            answer++;
        }
    }

    return answer;
}
