## 383. Ransom Note
#### 1. 문제 파악
- `ransomNote`, `magazine` 문자열이 주어진다.
- `magazine`의 문자열에서 `ransomNote`에 있는 문자열을 만들 수 있다면 `true`, 아니면 `false`
- 각 문자는 딱 한번만 만들 수 있다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- `magazine`의 문자를 dict or map 컬렉션을 사용하여 단어의 갯수를 센다.
- `ransomNote`를 돌면서 각 단어의 카운팅을 빼고, 만약 0보다 작거나 없다면 바로 `false` 반환
- 도는 동안 아무 일도 발생하지 않았다면 `true` 반환
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 이보다 짧게 처리하는 방법도 있다. `replace`를 활용하여 대체가 안될 경우 바로 `false` 처리
```javascript
function canConstruct(ransomNote, magazine) {
  for (const c of magazine) {
    ransomNote = ransomNote.replace(c, '');
  }
  if (!ransomNote) return false;
  
  return true;
}
```
