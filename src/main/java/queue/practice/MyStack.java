package queue.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈
 */
public class MyStack {
    private Queue<Integer> q;
    private int top;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        top = x;
    }

    public int pop() {
        // 创建另一个队列 q2
        Queue<Integer> q2 = new LinkedList<>();

        // 除了最后一个元素，将q中的所有元素放入q2
        while (q.size() > 1) {
            // 每从 q 中取出一个元素都给 top 赋值
            // top 最后存储的是 q 中除了队尾巴元素以外的最后一个元素
            top = q.peek();
            q2.add(q.remove());
        }

        // q 中剩下的元素就是 "栈顶" 元素
        int ret = q.remove();

        // 此时， q2 是整个数据结构存储的所有其他数据，赋值给 q
        q = q2;

        // 返回 "栈顶" 元素
        return ret;
    }

    public int top() {
        return top;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

}
