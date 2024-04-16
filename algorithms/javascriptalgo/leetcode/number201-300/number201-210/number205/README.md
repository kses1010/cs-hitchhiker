## 205. Isomorphic Strings 
#### 1. 문제 파악
- 문자열 `s`, `t` 가 주어지며 만약 둘이 Isomorphic 이면 `true`, 아니면 `false`
- Isomorphic 이란 `s` 문자열에서 각 문자가 `t` 문자열에 대체가능한지를 여부를 따진다.
- 문자의 순서를 유지하면서 모든 문자를 다른 문자로 바꿔야 한다.
- 문자열 `s`의 길이는 1 ~ 5 * 10^4
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 각 문자열을 for 문 돌면서 `indexOf(c, i + 1)`를 활용하여 현재 문자가 다른 index에도 똑같이 존재하는지 서로 비교
  - 여기서 `i + 1`을 하는 이유는 해당 문자 다음 인덱스부터 서치하기 위해 사용
- 만약 `indexOf(c, i + 1)` 했을 때 인덱스 값이 서로 같지 않을 경우 `false`, 전부 통과한다면 `true`
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 제일 간단한 방법으로는 각 Map을 사용하여 각 문자마다 연결되는 문자를 연결한다.
```javascript
// 예시: egg add
  const sMap = new Map();
  const tMap = new Map();

  for (let i = 0; i < s.length; i++) {
    const sChar = s[i];
    const tChar = t[i];

    if (sMap.has(sChar)) {
      if (sMap.get(sChar) !== tChar) {
        return false;
      }
    } else {
      sMap.set(sChar, tChar); // e -> a 
    }

    if (tMap.has(tChar)) {
      if (tMap.get(tChar) !== sChar) {
        return false;
      }
    } else {
      tMap.set(tChar, sChar); // a -> e
    }
  }

```
