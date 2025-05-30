## 424. Longest Repeating Character Replacement
#### 1. 문제 파악
- 문자열 s와 정수 k가 주어집니다. 
- 문자열의 모든 문자를 선택하여 다른 대문자 영어 문자로 변경할 수 있습니다. 
- 이 작업은 최대 k번 수행할 수 있습니다.
- 위의 연산을 수행한 후 얻을 수 있는, 같은 문자를 포함하는 가장 긴 부분 문자열의 길이를 반환합니다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 슬라이딩 윈도우 기법을 사용하는데 왼쪽 오른쪽을 사용하여 문자열의 최대길이를 지정한다.
- 윈도우 내 문자의 등장 빈도를 미리 배열로 세팅한다. (`Array(26).fill(0)`)
- 윈도우 내 가장 많이 등장한 문자의 수를 maxCount 로 갱신한다.
- for 문을 돌면서 right 기준으로 s 길이만큼 돈다.
  - 각 right 인덱스의 알파벳마다 count 배열에 해당 알파뱃을 카운딩한다. `charCodeAt` 과 -65를 하여 알파뱃 숫자가 해당 인덱스를 의미하도록 한다.
  - 윈도우 내 최대 빈도수를 업데이트 한다.(maxCount, 현재 알파뱃 카운트)
  - while 문 조건으로 이행해야하는데,
    - 윈도우내 (right - left + 1)에서 maxCount(최대 빈도수)를 뺀 값이 k보다 크다면 -> 즉, 바꿔야할 횟수가 k보다 많다면
    - 왼쪽 인덱스의 알파벳 카운트를 -1을 하고 왼쪽인덱스 + 1을 하여 윈도우를 압축시킨다.
  - 윈도우의 최대길이를 갱신한다.
- 윈도우의 길이를 리턴한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
