## 226. Invert Binary Tree
#### 1. 문제 파악
- 이진 트리를 가운데 기준으로 반전된 트리를 반환하기
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 재귀를 사용한다고 가정하면 재귀 탈출 조건부터 정한다.
  - 재귀 탈출 조건은 현재 `root`가 null 일 경우 null 을 반환한다.
  - 모든걸 통과했다면 `root`를 반환한다.
- 왼쪽, 오른쪽 Node 를 재귀함수를 사용해서 끝까지 간다.
- 그 다음에 해당 root 의 왼쪽과 오른쪽을 끝까지 간 오른쪽, 왼쪽으로 교환한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 좀 더 명확하게 푸는 방법이 있다.
```javascript
const invertTree = (root) => {
  if (!root) return null;
  
  const node = new TreeNode(root.val);
  
  node.right = invertTree(root.left);
  node.left = invertTree(root.right);
  
  return node;
}
```
