## 멀리 뛰기
#### 1. 문제 파악
- 한번에 1칸 또는 2칸을 뛸 수 있다.
- 멀리 뛰기에 사용될 칸의 수 n이 주어질 때, 끝에 도달하는 방법이 몇가지 있는지 알아내 1234567을 나눈 나머지를 리턴하기
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 전형적인 DP 문제
- 배열을 n + 1 만큼 주어지고 그 뒤에 점화식을 작성한다.
```
dp[i] = dp[i - 2] + dp[i - 1]
```
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
