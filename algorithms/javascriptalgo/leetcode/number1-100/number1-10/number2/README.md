## 2. Add Two Numbers
#### 1. 문제 파악
- 두 개의 음수가 아닌 정수를 나타내는 두 개의 비어 있지 않은 연결 목록이 제공됩니다. 
- 숫자는 역순으로 저장되며 각 노드에는 단일 숫자가 포함됩니다. 
- 두 숫자를 더하고 그 합계를 연결된 목록으로 반환합니다.
![img.png](img.png)
- l1, l2 의 길이는 같지 않다.
#### 2. 재정의와 추상화
example1
- Input: l1 = [2,4,3], l2 = [5,6,4]
- Output: [7,0,8]

example2
- Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
- Output: [8,9,9,9,0,0,0,1]
#### 3. 계획 세우기
- l1, l2, 그리고 두 값이 10을 넘을 경우 1을 보충해주는 carry를 변수로 둔다.
- Linked List의 head를 임시로 둔다.
- l1, l2 가 null이 아니거나 carry가 0이 아닐 경우 다음 상황을 진행한다.
  1. Linked List l1, l2가 null 일 경우 0, 아니라면 해당 값을 따로 지정한다.
  2. 두 값과 carry 값을 합친다. (sum)
  3. carry를 합친 값(sum)에서 10으로 나눈 값을 가진다. (0 or 1)
  4. head의 다음값 next는 새로운 Linked List를 가리키며 그 값은 `sum & 10`으로 한다. 그 뒤에 바로 head는 head.next를 가리킨다.
  5. l1, l2 는 각각 null이 아니라면 그다음 값을 가리키도록 한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 자바스크립트의 `toFixed()`는 반올림이 적용된다. 즉, 소수점 버리기가 아니다.
- 소수점을 정확하게 버리려면 `Math.floor`를 사용해야 한다.
- 또는 `parseInt`를 사용하는 방법이 있다.
- 회귀로 푸는 방법이 있다. 신통방통하다.
```javascript
const addTwoNumbers = (l1, l2, carry = 0) => {
  if (!l1 && !l2 && !carry) {
    return null;
  }

  let total = (l1 ? l1.val : 0) + (l2 ? l2.val : 0) + (carry || 0);
  carry = parseInt(total / 10);
  return new ListNode(total % 10, addTwoNumbers(l1?.next, l2?.next, carry));
};
```
