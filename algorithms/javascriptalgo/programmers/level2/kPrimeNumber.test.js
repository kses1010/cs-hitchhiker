test("test", () => {
    let n1 = 437674;
    let k1 = 3;

    let n2 = 110011;
    let k2 = 10;

    expect(solution(n1, k1)).toBe(3);
    expect(solution(n2, k2)).toBe(2);
});

function solution(n, k) {
    let answer = 0;

    function isPrime(num) {
        if (!num || num === 1) {
            return false;
        }
        for (let i = 2; i <= Math.sqrt(num); i++) {
            if (num % i === 0) {
                return false;
            }
        }
        return true;
    }

    let kNum = n.toString(k);
    let splits = kNum.split("0");

    return splits.filter(v => isPrime(+v)).length;
}
