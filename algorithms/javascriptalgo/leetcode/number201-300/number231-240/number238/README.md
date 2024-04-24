## 238. Product of Array Except Self
#### 1. 문제 파악
- 정수 배열 `nums`이 주어지면, `nums[i]`를 제외한 `nums`의 모든 요소의 곱을 담은 배열을 반환하기
- 반드시 시간복잡도 O(n)에 실행해야하며, 나누기 연산은 사용하지 않는다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 방향마다 곱셈 처리하기 위해 `left`, `right`를 전부 1로 할당
- 오른쪽에서 왼쪽으로 처리하기
  - 해당 인덱스를 `right`로 할당 -> `answer[i] = right`
  - `right`를 해당 정수배열의 숫자로 곱셈하여 추가적 곱셈 갱신 -> `right *= nums[i]`
- 왼쪽에서 오른쪽으로 처리하기
  - 오른쪽에서 왼쪽으로 처리했던 결과에서 `left`값을 곱셈처리
  - `left`를 해당 정수배열의 숫자로 곱셈하여 추가적 곱셈 갱신 -> `left *= nums[i]`
- 자바스크립트에서는 `-0`과 `0`은 다른값이기 때문에 `-0`일 경우 `0` 처리 추가
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 그러나 이 풀이는 다른사람보다 속도가 많이 느리다. `132ms`가 나왔다.
- 더욱 빠르게 푸는 방법은 다음과 같다.
```javascript
function productExceptSelf(nums) {
  const answer = [];
  let prefix = 1;
  let postfix = 1;
  
  for (let i = 0; i < nums.length; i++) {
    answer[i] = prefix;
    prefix *= nums[i];
  }
  
  for (let i = nums.length - 2; i >= 0; i--) { // 어차피 마지막 인덱스는 자신을 빼고 하기 때문에 -2
    postfix *= nums[i + 1]; // i + 1이 있기 때문에 출발 인덱스를 length - 2로 잡은 것
    answer[i] *= postfix;
  }
  
  return answer;
}
```
