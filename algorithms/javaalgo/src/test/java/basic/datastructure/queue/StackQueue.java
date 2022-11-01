package basic.datastructure.queue;

import java.util.Stack;

public class StackQueue<T> {

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    private void moveIfAbsent() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public void add(T t) {
        stack1.push(t);
    }

    public T peek() {
        moveIfAbsent();
        return stack2.peek();
    }

    public T poll() {
        moveIfAbsent();
        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}
