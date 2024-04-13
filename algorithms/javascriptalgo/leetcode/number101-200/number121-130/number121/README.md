## 121. Best Time to Buy and Sell Stock
#### 1. 문제 파악
- 가격 배열 `prices`에 i일 가격이 있다.
- 하나의 날짜를 골라 미래에 다른 날짜의 가격에 판매를 하는데 최대값을 구해야 한다.
- 만약 다 돌았는데 이득이 없다면 0을 반환

#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 가장 간단한 방법은 for 문을 사용하여 매번 최소값을 구하고 선택한 현재 가격과 최소값을 뺀 값과 answer 값의 최대값으로 비교
- 두번째 방법은 산 index, 판 index 이용하기
  - buyIndex < sellIndex 즉, 팔아도 될 날짜일 경우 조건문 활용
  - answer 값과 `prices[sell]` - `prices[buy]` 값의 최대값 비교
  - 만약 해당 조건문을 타지 않을 경우 buyIndex 를 sellIndex 로 할당
  - 조건문이 끝나면 sellIndex 는 1씩 증가

#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고

