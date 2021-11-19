package queue.practice;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    int front;

    public MyQueue() {
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        // 如果 s2 不为空， 直接返回 s2 的栈首元素
        if(!s2.isEmpty()){
            return s2.pop();
        }

        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        return s1.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        while (!q.empty()) {
            System.out.println(q.pop());
        }
    }
}