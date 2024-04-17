## 36. Valid Sudoku
#### 1. 문제 파악
- `9 x 9` 이차원 배열이 있다.
- 다음 룰에 알맞는 룰로 해당 배열을 채워야 한다.
  - 가로줄에 1 ~ 9까지 중복없이 있어야 한다.
  - 세로줄에 1 ~ 9까지 중복없이 있어야 한다.
  - 각 `3 x 3` 작은 박스에 반드시 1 ~ 9까지 중복없이 있어야 한다.
- 주어진 스도쿠 판을 두고 해당 스도쿠가 올바른 스도쿠 판인지 판단하여 `true`, `false`로 반환 할 것.
- 스도쿠판은 꼭 풀 수 있는 보드일 필요는 없다. 주어진 판이 타당한지만 판단 할 것.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 가로 줄, 세로 줄 `3 x 3` 그리드 마다 룰을 지키고 있는지 완전탐색을 사용하여 확인이 가능하다.
- 가로 줄, 세로 줄 모두 for loop 돌때마다 HashSet으로 중복이 되는지 확인
- 그리드는 top, right, left, bot 을 선정하여 해당 기준이 통과 될 떄마다 +3 증가하여 실행
  - right 가 9보다 클 때마다 0으로 초기화
  - bot 이 9보다 클 경우 반복문 종료 
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- Grid에서 사소한 문제로 시간을 너무 많이 잡아먹었다. 결국엔 디버거를 사용함
- 사소한 문제점은 다음과 같다.
```javascript
const isValidGrid = (top, bot, left, right) => {
  for (let i = top; i <= bot; i++) {
    for (let j = left; i <= right; j++) { // 실수로 i로 적음
      let element = board[i][j];
      if (pattern.test(element)) {
        if (set.has(element)) {
          return false;
        }
      }
      set.add(element); // 실수로 set add 를 하지 않아 Grid에서 중복을 체크하지 못함
    }
  }
  set.clear();
  return true;
}
```
