## 20. Valid Parentheses
#### 1. 문제 파악
- 문자열 `s`는 오직 `'(', ')', '{', '}', '[', ']'` 으로 이루어져 있다.
- 이 문자열이 유효한지 조건은 다음과 같다.
  - 열린 괄호는 반드시 같은 타입의 닫힌 괄호가 있다.
  - 열린 괄호는 반드시 올바른 순서로 닫힌 괄호가 있다.
  - 모든 닫힌 괄호는 동일한 유형의 해당 열린 괄호가 있다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 각 괄호 타입마다 연결되는 map 또는 객체를 사용하여 설정한다.
- for loop 를 돌면서 열린 괄호는 스택에 저장
- 만약 닫힌 괄호라면 다음 조건을 만족하지 않을 시 `false` 를 반환
  - 스택이 비어있을 경우
  - 스택의 pop한 열린 괄호가 닫힌 괄호와 같은 타입이 아닐 경우
- 이 모든걸 통과하고 스택이 비워있다면 `true` 반환
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
