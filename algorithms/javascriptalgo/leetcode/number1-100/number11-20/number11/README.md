## 11. Container With Most Water
#### 1. 문제 파악
- 길이 `n`을 가진 숫자 배열 `height`.
- `n` 개의 수직선이 있다. 양 끝을 `(i, 0)`, `(i, height[i])`로 지정한다.
- X 축과 각 두 수직선이 포함한 것을 컨테이너라고 하며 가장 많은 물을 담을 수 있는 값을 반환한다.
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 양쪽을 엔드포인트로 선언하고, 둘 중에 값이 작은 값이면 이동하도록 한다. 왼쪽과 오른쪽이 일치할 때까지 실행
  - 왼쪽이 작다? `left++`
  - 오른쪽이 작다? `right--`
- 이동할 때마다 각 컨테이너를 계산하는데, 계산식은 다음과 같다.
  - `(right - left) * Math.min(height[left], height[right])`
- 이후 현재 값과 계산된 값을 비교하여 큰값을 할당한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
