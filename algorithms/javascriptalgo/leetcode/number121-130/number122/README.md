## 122. Best Time to Buy and Sell Stock 2
#### 1. 문제 파악
- 가격 배열 `prices`에 i일 가격이 있다.
- 각 날마다, 주식을 사거나 팔 수 있으며, 판 날짜에 바로 구입도 가능하다.
- 어느 날짜든 최소한 한개의 주식을 가지고 있다.

#### 2. 재정의와 추상화
#### 3. 계획 세우기
간단한 방법은 지금 가격과 다음 날짜의 가격을 비교하여 다음 날짜의 가격이 클 경우 차감하여 answer 값에 더한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
최저에서 사고 고점에서 파는 방법으로 while 문을 활용하여 buy, sell 인덱스의 값을 구하는 방법을 해야한다.
```javascript
let days = prices.length;
while (buy < days - 1 && prices[buy + 1] < prices[buy]) { // 이 조건은 현재값이 그 다음 날짜 값보다 비쌀 경우를 의미
  buy++; // 최저에서 사기 위해 계속해서 날짜 이동
}

sell = buy; // 샀던 날짜 기준으로 파는 날짜 이동

while (sell < days - 1 && prices[sell + 1] > prices[sell]) { // 이 조건은 현재값이 그 다음 날짜보다 값이 쌀 경우를 의미
  sell++; // 고점에서 팔기 위해 계속해서 날짜 이동
}
answer += prices[sell] - prices[buy];
buy = sell + 1;
```
