## 74. Search a 2D Matrix
#### 1. 문제 파악
- 주어진 이차원 배열(`m * n`)은 각 행마다 정렬되어 있다.
- 이 이차원 배열에서 해당 숫자(target)을 찾을 경우 `true`, 아니면 `false`를 반환한다.
- 시간 복잡도는 `O(log(m * n))`
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 행, 열을 0, `matrix[0].length - 1`을 할당한다.
- 행이 matrix 보다 작거나, 열이 0보다 클 때까지
  - 찾으면 `true`를 반환한다.
  - target이 해당 요소보다 크다면 열 - 1
  - target이 해당 요소보다 작다면 행 + 1
- 끝까지 도달했는데 없다면 `false` 반환한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 지금 풀이법은 사실 `O(m + n)`에 가깝다. 실제로 더 압축하려면 다음 처럼 `mid`를 구한다.
```javascript
var searchMatrix = function (matrix, target) {
  let m = matrix.length;
  let n = matrix[0].length;
  let left = 0
  let right = m * n - 1; // 가장 오른쪽 하단 요소

  while (left <= right) {
    let mid = Math.floor(left + (right - left) / 2);
    let midNum = matrix[Math.floor(mid / n)][mid % n];

    if (midNum === target) return true;
    if (midNum < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return false;
};
```
