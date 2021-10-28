package from200;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution225 {

    /**
     * 使用队列实现栈
     */
    public static class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            Queue<Integer> tmpQueue = new ArrayDeque<>();
            int value;
            while (!queue.isEmpty()) {
                value = queue.poll();
                if (queue.isEmpty()) {
                    queue = tmpQueue;
                    return value;
                }
                tmpQueue.offer(value);
            }

            // 因为题目假设不会在栈空的时候弹出元素，所以这里不会执行到，随便返回一个值
            return -1;
        }

        public int top() {
            int value = pop();
            queue.offer(value);

            return value;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
