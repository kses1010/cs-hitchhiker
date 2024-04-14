## 209. Minimum Size Subarray Sum
#### 1. 문제 파악
- 양수 배열 `nums`, 양수 `target`
- 최소 길이의 연속된 요소 시퀀스(`subarray`)를 구한다.
  - 그 시퀀스의 합이 `target` 보다 크거나 같아야 한다.
- 만약 해당 `subarray`가 없다면 0을 반환한다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 배열의 첫 인덱스에서 슬라이딩 윈도우 기법을 활용해서 조금씩 윈도우를 늘리고 옮기는 방식을 사용한다.
- `answer`는 최대값을 활용(`infinity`)
  - 만약 현재 윈도우 안에 있는 값의 합이 `target`과 같거나 작다면 오른쪽을 확장(`end++`)
    - `answer`과 윈도우 길이의 최소값 비교(`Math.min`)
  - 만약 현재 윈도우 안에 있는 값의 합이 `target`과 크다면 왼쪽 축소(`start--`)
- 만약 `answer`가 1이 나온다면 바로 리턴
- `start`가 끝까지 도착할 때까지 `target` 조건에 만족하지 못한다면 0을 리턴
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 처음에 실패한 이유는 `end`가 끝나는 조건이 배열 밖에 염두를 두지 않아 NaN이 발생하여 0으로 반환
- 쉽게 푸는 방법으로는 내부적으로 while문을 활용하여 윈도우 왼쪽 부분을 축소 할 수 있는만큼 하도록 설정하면 된다.
```javascript
var minSubArrayLen = function(target, nums) {
  let minSize = Number.MAX_SAFE_INTEGER;
  let left = 0;
  let currSum = 0;
  for (let i = 0; i < nums.length; i++) {
    currSum += nums[i];
    while (currSum >= target) {
      minSize = Math.min(minSize, i - left + 1)
      currSum -= nums[left]
      left++
    }
  }
  return minSize === Number.MAX_SAFE_INTEGER ? 0 : minSize;
}
```
