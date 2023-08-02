test("test", () => {
    let people1 = [70, 50, 80, 50];
    let people2 = [70, 80, 50];

    expect(solution(people1, 100)).toBe(3);
    expect(solution(people2, 100)).toBe(3);
});

function solution(people, limit) {
    let answer = 0;
    people.sort((a, b) => b - a);
    let left = 0;
    let right = people.length - 1;

    while (left < right) {
        let sum = people[left] + people[right];
        if (sum > limit) {
            left++;
        } else {
            left++
            right--;
        }
        answer++;
    }
    if (left === right) {
        answer++;
    }
    return answer;
}
