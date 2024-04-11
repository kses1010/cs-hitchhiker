## 189. Rotate Array
#### 1. 문제 파악
- 숫자 배열 `nums`, 오른쪽으로 회전 양수는 `k`

#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 가장 쉬운 방법으로는 `k % nums.length` 숫자만큼 배열을 잘라서 새로운 배열에 담기
- Follow up에서 가능하다면 새로운 배열이 아닌 O(1) 메모리 공간에서 해결해 달라고 했다.
  - target을 `k % nums.length`로 선언하기
  - 3단계를 거친다.
  1. 전체적으로 reverse
  2. 0 ~ `target - 1` 인덱스만큼 reverse
  3. target ~ nums.length - 1 부분만 reverse

#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 시작

### 6. 회고
