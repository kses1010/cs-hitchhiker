## 33. Search In Rotated Sorted Array
#### 1. 문제 파악
- 오름차순으로 정렬된(고유한 값을 갖는) 정수 배열 `nums`가 있습니다.
- 함수에 전달되기 전에 nums는 알려지지 않은 피벗 인덱스 k(1 <= k < nums.length)에서 회전되어 
- 결과 배열이 `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]`(0부터 인덱스)가 될 수 있습니다. 
- 예를 들어, [0,1,2,4,5,6,7]은 피벗 인덱스 3에서 회전되어 [4,5,6,7,0,1,2]가 될 수 있습니다.
- 가능한 회전 후의 배열 `nums`와 `target`이 주어지면, `nums`에 있으면 `target`의 인덱스를 반환하고, `nums`에 없으면 -1을 반환합니다.
- 시간 복잡도는 `O(logn)`이어야 합니다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 왼쪽(left), 오른쪽(right)을 포인트로 두고 진행한다. (left = 0, right = nums.length - 1)
- while 문을 사용해서 (left < right) 조건에 해당하는 동안
  - 중앙 인덱스(mid)를 구하고 (left + (right - left) / 2)
  - 만약 중앙값(`nums[mid]`)가 오른쪽 값(`nums[right]`)보다 크다면 왼쪽은 mid + 1로 할당한다.
  - 그렇지 않다면 오른쪽은 mid 로 할당한다.
- while 문을 나오면 pivot(rotate 했던 기준 값)을 left 값으로 할당한다.
- 다시 왼쪽(left), 오른쪽(right)을 재할당하고 (left = 0, right = nums.length - 1)
- while 문을 사용해서 (left <= right) 조건에 해당하는 동안
  - 중앙 인덱스(mid) = left + (right - left) / 2
  - 중앙 pivot 값(midPivot)을 구한다. (pivot + mid) % nums.length; => rotate 했던 기준으로 mid 중앙 인덱스를 찾는 과정이다.
  - 만약 `nums[midPivot]` 값이 target 보다 작다면, left = mid + 1;
  - 만약 `nums[midPivot]` 값이 target 보다 크다면, right = mid + 1;
  - 찾게 되면 해당 midPivot(인덱스)를 리턴한다.
- while 문을 그대로 탈출하면 못찾았다는 뜻이므로 -1 을 리턴한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
