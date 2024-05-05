## 21. Merge two Sorted Lists
#### 1. 문제 파악
- 두 개의 오름차순으로 정렬된 Linked List가 있다. `list1`, `list2`
- 두 Linked List 를 오름차순으로 정렬된 Linked List 로 합치도록 해야한다.
예시
```
1 -> 2 -> 4
1 -> 3 -> 4
병합: 1 -> 1 -> 2 -> 3 -> 4 -> 4 
```
#### 2. 재정의와 추상화
#### 3. 계획 세우기
우선적으로 Linked List 문제들은 대부분 재귀함수를 많이 사용하므로 재귀함수를 쓰는 방향으로 생각해보자.
- 먼저, 각 Linked List가 null 또는 undefined 면 상대 list 를 리턴하도록 설정한다.
- 만약 list1의 val이 list2의 val 보다 작다면
  - list1가 가리키는 방향은 재귀함수를 가리킨다. 
  - `list1.next = recur(list1.next, list2)`
  - list1 을 반환한다.
- 반대면 list2가 가리키는 방향은 재귀함수를 가리킨다.
  - `list2.next = recur(list1, list2.next)`
  - list2 를 반환한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
