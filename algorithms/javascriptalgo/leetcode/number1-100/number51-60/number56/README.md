## 56. Merge Intervals
#### 1. 문제 파악
- 인터벌[start, end] 인 배열이 주어지면 겹치는 모든 인터벌은 합치고 입력의 모든 간격을 포괄하는 겹치지 않는 인터벌의 배열을 반환한다.
- 인터벌의 배열의 길이는 1에서 1000 사이
- start, end의 값은 1에서 1000 사이
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 주어진 인터벌을 start 기준으로 오름차순으로 정렬한다.
- 각 배열을 for loop 를 돌면서 end의 최대값을 비교한다.
- 만약 인터벌[0]이 end의 값보다 작으면
  - end는 인터벌[1]과 최대값 비교
- 아니면
  - 새로운 배열을 만들어 [인터벌[0], 인터벌[1]]을 answer값에 추가하고,
  - start, end는 인터벌[0], 인터벌[1]로 할당한다.
- for loop 가 끝나면 마지막으로 start, end 를 새로운 배열로 추가하여 answer값에 추가한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 새로운 배열을 생성해서 넣지 않고 intervals 메모리 그대로 사용하는 방법도 있다.
```javascript
var merge = function (intervals) {
  intervals.sort((a, b) => a[0] - b[0]);
  let i = 0;
  while (i < intervals.length - 1) {
    if (intervals[i][1] >= intervals[i + 1][0]) { // 지금 주어진 인터벌의 end값이 다음 인터벌 start값보다 클 경우
      intervals[i][1] = Math.max(intervals[i][1], intervals[i + 1][1]); // 지금 end값을 다음 인터벌 end값과 최대값 비교
      intervals.splice(i + 1, 1); // 다음 인터벌 배열은 삭제
    } else {
      i += 1;
    }
  }
  return intervals;
}
```
