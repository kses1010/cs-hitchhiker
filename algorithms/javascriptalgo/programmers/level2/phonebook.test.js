test("test", () => {
    const phoneBook1 = ["119", "97674223", "1195524421"];
    const phoneBook2 = ["123", "456", "789"];
    const phoneBook3 = ["12", "123", "1235", "567", "88"];

    expect(solution(phoneBook1)).toBeFalsy();
    expect(solution(phoneBook2)).toBeTruthy();
    expect(solution(phoneBook3)).toBeFalsy();
});

function solution(phoneBook) {
    phoneBook.sort();
    for (let i = 0; i < phoneBook.length - 1; i++) {
        if (phoneBook[i + 1].startsWith(phoneBook[i])) {
            return false;
        }
    }
    return true;
}
