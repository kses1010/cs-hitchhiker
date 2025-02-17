## 206. Reverse Linked List 
#### 1. 문제 파악
- 단일 연결 리스트의 헤드가 주어지면 리스트를 반전시키고 반전된 리스트를 반환합니다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- reverse 함수를 만들어 재귀하도록 한다.
  - 매개변수는 node, 이전 노드인 prev를 받고
  - 만약 node 가 비워져있으면(null or undefined) 바로 prev 리턴
  - next 노드를 node.next 로 할당하고
  - node.next 는 prev 로 할당
  - reverse 재귀 리턴으로 next, node 매개변수를 갖도록 한다.
- reverse 함수를 호출할 때 head, null 매개변수를 두고 리턴한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
