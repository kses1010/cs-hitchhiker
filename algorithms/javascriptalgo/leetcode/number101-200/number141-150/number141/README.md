## 141. Linked List Cycle
#### 1. 문제 파악
- 주어진 Linked List `head`가 cycle 인지 아닌지 판단하는 문제
- 포인터를 따라가면 다시 도달할 수 있는 노드가 있다면 Cycle
- 내부적으로 `pos`는 `tail`의 다음 포인터가 연결된 노드의 색인을 나타내는데 사용하며, `pos`는 매개변수로 전달되지 않는다. 
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 우선적으로 `head`와 `head.next` 가 없다면 `false` 처리한다.
- Linked List를 두 개의 포인터를 둔다. `slow`, `fast`
  - `slow`는 다음 노드를 가리킨다. => `slow = slow.next`
  - `fast`는 다다음 노드를 가리킨다. => `fast = fast.next.next`
- 만약 빠른 포인터인 `fast`가 `slow`와 일치한다면, Cycle이고
- 만약 빠른 포인터인 `fast`가 끝에 도달해서 끝난다면 Cycle이 아니다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
