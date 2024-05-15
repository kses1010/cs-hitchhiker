## 49. Group Anagram
#### 1. 문제 파악
- 주어진 문자열 배열을 주고 아나그램이 해당되는 그룹끼리 묶어 이차원배열로 반환한다. (반환할 때 어떤 순서든 상관없다.)
- 문자열 배열의 길이는 10^4
- 문자열 각자의 길이는 100
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 맵을 활용하는데 키는 문자열 값은 문자열 배열로 지정한다.
- 만약 문자열이 맵키에 없다면
  - 문자열 키 기준으로 새로운 배열을 만든다.
- 문자열 키 기준으로 해당 문자열을 push 한다.
- 마지막으로 맵의 값을 반환한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 시간복잡도 / 공간복잡도를 좀 더 압축시키는 방법으로 brute force 방법이 있다.

```javascript
/**
 * @param {string} s
 * @return {string}
 */
var getSignature = function (s) {
  const count = Array(26).fill(0);
  for (const c of s) {
    count[c.charCodeAt(0) - 'a'.charCodeAt(0)]++; // 알파벳을 전부 아스키코드 번호로 해당하는 번호를 plus 한다.
  }

  const result = [];
  for (let i = 0; i < 26; i++) {
    if (count[i] !== 0) {
      result.push(String.fromCharCode(i + 'a'.charCodeAt(0)), count[i].toString()); // 0이 아닌 해당 인덱스를 문자로 되돌린다.
    }
  }

  return result.join(''); // 문자열로 변환
};

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
  const result = [];
  const groups = new Map();

  for (const s of strs) {
    const signature = getSignature(s);
    if (!groups.has(signature)) {
      groups.set(signature, []);
    }
    groups.get(signature).push(s);
  }

  groups.forEach(value => result.push(value));
  return result;
};
```
