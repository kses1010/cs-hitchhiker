## 100. Same Tree
#### 1. 문제 파악
- 두 개의 이진트리 p, q가 똑같은 트리인지 확인하여 `true`, `false`로 반환한다.
#### 2. 재정의와 추상화
#### 3. 계획 세우기
- 둘 다 같은 이진트리인지 확인하려면 먼저 조건을 확인해야한다.
  1. 둘 다 노드값이 null 일 경우
  2. 둘 다 값이 같을 경우
- 이 외에는 전부 false 처리한다.
- 그리고 재귀를 사용하여 p, q의 각각 왼쪽 오른쪽을 탐색하며 둘다 같은 반환값을 하는지 `&&` 연산자로 확인한다.
#### 4. 검증하기
#### 5. 계획 수행하기
- 코딩 실행

### 6. 회고
- 이진트리를 해결할 때 bfs로 해결하는 방법도 있다.
```javascript
var isSameTree = function (p, q) {
    const check = (p, q) => {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    const queue = [[p, q]];
    while (queue.length) {
        [p, q] = queue.shift();
        if (!check(p, q)) return false;
        if (p || q) { 
            queue.push([p.left, q.left])
            queue.push([p.right, q.right])
        }
    }
    return true;
};
```
