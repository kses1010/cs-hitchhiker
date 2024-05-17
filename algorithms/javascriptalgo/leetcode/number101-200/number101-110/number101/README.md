## 101. Symmetric Tree
#### 1. 문제 파악
- 주어진 이진트리에서 중앙으로 봤을 때 거울처럼 똑같이 트리를 구성했다면 `true` 아니면 `false` 를 반환한다.
![img.png](img.png)
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- root를 기준으로 왼쪽, 오른쪽을 재귀탐색을 시작한다.
- 반환하는 조건은 다음과 같다.
  - 만약 왼쪽, 오른쪽 모두 null 이라면 `true`를 반환. 둘 다 하위트리가 없다는 뜻.
  - 만약 위 조건을 만족하지 않고 왼쪽, 오른쪽 중에 하나만 null 이라면 `false` 반환. 둘 중에 하나만 하위트리를 가지고 있지 않다는 뜻
  - 만약 왼쪽의 값, 오른쪽의 값이 같지 않다면 `false` 반환. 거울처럼 같은 값을 가져야하는데 가지고 있지 않기 때문
- 마지막으로 `&&`연산자를 사용하여 
  - 왼쪽의 왼쪽, 오른쪽의 오른쪽 재귀
  - 왼쪽의 오른쪽, 오른쪽의 왼쪽 재귀
- 를 사용하여 둘다 똑같은 boolean을 가지고 있는지 확인한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 다음과 같이 bfs 방식으로 해결이 가능하다.
```javascript
var isSymmetric = function (root) {
    if (root == null) return true;
    let queue = [root.left, root.right];
    while (queue.length > 0) {
        let leftNode = queue.shift();
        let rightNode = queue.shift();
        if (leftNode == null && rightNode == null) continue; // 둘다 노드가 null 이면 통과. 하위트리가 없기 때문
        if (leftNode == null || rightNode == null || leftNode.val !== rightNode.val) {
            return false;
        }
        queue.push(leftNode.left, rightNode.right); // ... 이라 두개의 값이 동시에 들어간다.
        queue.push(leftNode.right, rightNode.left);
    }
    return true;
}
```
