## 캐시
#### 1. 문제 파악
- 캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
- cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다.
- cities는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
- 각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 
- 도시 이름은 최대 20자로 이루어져 있다.
- 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
  - cache hit일 경우 실행시간은 1이다.
  - cache miss일 경우 실행시간은 5이다.
- 입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 캐시 사이즈가 0일 경우 도시 배열 x 5를 바로 리턴한다.
- 캐시 배열을 담는 `cache[]`을 초기화한다.
- 도시 배열을 for 문을 돌면서 실행시간을 체킹한다.
  - 이 때, 혹시 모를 소문자, 대문자 이슈때문에 `toLowerCase()` or `toUpperCase()`를 사용한다.
- 뽑은 도시의 캐시에 존재하는지 그리고 존재한다면 해당 인덱스를 가져온다. (`indexOf()`)
  - 만약 존재한다면, 해당 인덱스에서 요소를 제거하고 실행시간 +1을 더한다.
  - 만약 존재하지 않을 때,
    - 만약 현재 캐시의 길이가 캐시사이즈보다 같거나 크다면, 맨 뒤에 캐시를 날린다.(`shift()`)
    - 그리고 실행시간 +5을 더한다.
  - 조건을 확인 후 캐시 배열에 해당 도시이름을 더한다.(`push()`)
- 최종적으로 걸린 시간을 리턴한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
