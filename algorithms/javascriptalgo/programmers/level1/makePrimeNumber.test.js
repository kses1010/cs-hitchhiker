test("test", () => {
    var nums1 = [1, 2, 3, 4];
    var nums2 = [1, 2, 7, 6, 4];

    expect(solution(nums1)).toBe(1);
    expect(solution(nums2)).toBe(4);
});

function solution(nums) {
    let length = nums.length;
    let answer = 0;

    for (let i = 0; i < length - 2; i++) {
        for (let j = i + 1; j < length - 1; j++) {
            for (let k = j + 1; k < length; k++) {
                if (isPrime(nums[i] + nums[j] + nums[k])) {
                    answer++;
                }
            }
        }
    }
    return answer;
}

function isPrime(n) {
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
}
