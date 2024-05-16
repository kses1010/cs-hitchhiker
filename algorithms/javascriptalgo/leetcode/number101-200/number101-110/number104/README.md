## 104. Maximum Depth Of Binary Tree
#### 1. 문제 파악
- root를 시작으로한 이진트리의 최대 깊이를 구하라
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 재귀를 사용하여 조건을 만족하면서 max값을 갱신한다.
- 조건은 다음과 같다.
  - 만약, root 가 null 일 경우 그대로 return 0을 반환한다.
  - 통과하면 각 방향마다 재귀를 돈다.
  - 마지막으로 왼쪽, 오른쪽의 최대값을 구하고 null이 아닌것을 확인했기 때문에 해당 값에 +1을 더한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 재귀가 아닌 bfs 로 해결하는 방법도 있다.
```javascript
var maxDepth = function (root) {
    if (root == null) return 0;
    let level = 0;
    let queue = [root];

    while (queue.length) {
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            let node = queue.shift(); // 지금 현재 큐에서 꺼내고
            if (node.left) {
                queue.push(node.left);
            }
            if (node.right) {
                queue.push(node.right)
            }
        }
        level += 1; // 큐에서 모두 꺼냈다면 +1을 더한다.
    }
    return level;
};
```
