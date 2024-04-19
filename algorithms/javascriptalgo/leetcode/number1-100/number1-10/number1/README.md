## 1. Two Sum
#### 1. 문제 파악
- 숫자 배열 `nums`, 숫자 `target`이 있다.
- 두개의 숫자를 골라 합을 더하여 `target`이 되는 인덱스를 반환한다.
- 반드시 한개의 답이 있다고 가정하며, 똑같은 요소를 두번 이상 사용할 수 없다.
- 시간 복잡도 O(n^2)가 아닌 알고리즘을 찾아보자.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 시간 복잡도를 생각하지 않는다면 이중 for문을 사용하는 방법이 있다.
- O(n) 알고리즘을 짠다고 하면 다음과 같다
1. Map 또는 객체를 만들고 key = 요소, value = index 로 저장한다.
2. for loop 를 돌면서 해당 요소가 Map에 있는 key 가 `target - nums[i]`와 일치하는지 체크한다.
3. 일치할 경우 [`target - nums[i]`, `i`]를 반환한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
Map 대신 객체로 해결하는 법

```javascript
var twoSum = function (nums, target) {
  const pairIdx = {};

  for (let i = 0; i < nums.length; i++) {
    const diff = target - nums[i];
    if (diff in pairIdx) { // in 문법을 사용하면 해당 키를 돌면서 확인할 수 있다.
      return [i, pairIdx[diff]];
    }
    pairIdx[num] = i;
  }
};
```
