package basic.livecoding;

import java.util.Deque;
import java.util.LinkedList;

public class LRUArray {

    int size;
    Deque<Integer> q = new LinkedList<>();

    public LRUArray(int size) {
        this.size = size;
    }

    public void add(int data) {
        if (!q.contains(data)) {
            if (q.size() == size) {
                q.pollLast();
            }
            q.addFirst(data);
        } else {
            q.remove(data);
            q.addFirst(data);
        }
    }

    @Override
    public String toString() {
        return "LRUArray: LRU = " + q;
    }
}
