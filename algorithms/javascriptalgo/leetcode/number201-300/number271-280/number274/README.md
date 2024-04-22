## 274. H-Index
#### 1. 문제 파악
- 숫자 배열 `citations`의 `citations[i]`는 i번째 논문에 대해 받은 인용 횟수를 의미한다.
- H-Index는 연구자가 h번 이상 인용된 적어도 h개의 논문을 출판했을 때의 h의 최대값으로 정의된다.
#### 2. 재정의와 추상화
- `[3,0,6,1,5]`는 연구자가 총 5개의 논문을 가지고 있고 각 논문이 각각 3, 0, 6, 1, 5번 인용되었음을 의미합니다. 
- 연구자가 각각 3회 이상 인용된 3개의 논문을 갖고 있고
- 나머지 2개 논문은 각각 3회 이하 인용되었으므로 해당 논문의 h-index는 3입니다.
#### 3. 계획 세우기
- 숫자 배열을 내림차순으로 정렬한다.
- `citations[answer]`가 `answer + 1` 보다 크거나 같을 경우 `answer++` 처리.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- for loop 문으로 만들어서 진행할 수 있다.
```javascript
var hIndex = function (citations) {
  citations = citations.sort((a, b) => b - a);
  let i;
  for (i = 0; i < citations.length; i++) {
    if (i >= citations[i]) {
      break;
    }
  }
  return i
};
```
