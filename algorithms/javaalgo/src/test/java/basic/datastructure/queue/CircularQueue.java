package basic.datastructure.queue;

public class CircularQueue {

    private int head;
    private int tail;
    private int size;
    private int[] arr;

    public CircularQueue(int k) {
        this.head = -1;
        this.tail = -1;
        this.size = k;
        this.arr = new int[k];
    }

    public boolean isEmpty() {
        return tail == -1;
    }

    public boolean isFull() {
        return ((head + 1) % size) == tail;
    }

    public boolean enQueue(int element) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            tail = 0;
        }
        head = (head + 1) % size;
        arr[head] = element;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        tail = (tail + 1) % size;
        return true;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[tail];
    }
}
