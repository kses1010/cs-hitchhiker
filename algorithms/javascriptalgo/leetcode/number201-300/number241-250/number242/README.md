## 242. Valid Anagram
#### 1. 문제 파악
- 두 문자열 `s`, `t`가 주어지며 `t`가 `s`의 아나그램이면 `true`, 아니면 `false` 반환
- 아나그램은 일반적으로 모든 원래 문자를 정확히 한 번 사용하여 다른 단어나 구문의 문자를 재배열하여 형성된 단어나 구문이다.
- 만약 유니코드 문자가 포함된다면 어떻게 처리 할 수 있을까?
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 두 문자열을 배열로 만든다음 정렬하여 각각 포인터를 이용하여 비교한다음 전부 통과하지 않을 경우 `false` 통과하면 `true`를 반환
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 또다른 간단한 방법으로는 Map 또는 객체를 사용하는 방법이 있다.
```javascript
var isAnagram = function (s, t) {
  if (s.length !== t.length) return false;

  let sMap = {}, tMap = {}
  for (let i = 0; i < s.length; ++i) {
    sMap[s[i]] = sMap[s[i]] + 1 || 1
  }

  for (let el of t) {
    if (!sMap[el]) {
      return false;
    } else {
      sMap[el] -= 1
    }
  }
  for (let el in sMap) {
    if (sMap[el] !== 0) return false;
  }
  return true;
};
```
