## 290. Word Pattern
#### 1. 문제 파악
- 문자열 `s`에는 `pattern` 이 있다.
- `pattern`에 전부 매칭이 된다면 `true`, 아니면 `false`
- 문자열 `s`의 각 단어들은 한 칸 정도의 빈공백이 있다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 먼저 문자열 `s`를 공백 기준으로 split -> 변수 words 
  - 만약 words 의 길이와 `pattern`의 길이가 다르면 `false`
  - 만약 Set 으로 words의 크기와 `pattern`의 크기가 다르다면 `false`
- Map 컬렉션을 사용하여 `pattern`인덱스마다 words 의 해당 인덱스 단어를 저장
  - 만약 인덱스의 `pattern` 단어와 words의 단어가 다르면 `false`
- 전부 통과할 경우 `true`
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- Set으로 중복이 없는 집합으로 가려내는 작업을 하지 않을 경우
```javascript
const pattern = "abba";
const s = "dog dog dog dog";
```
이 예시는 `true`를 반환한다.
- 이런 사소한 실수는 놓치지 않도록 생각해야겠다.
