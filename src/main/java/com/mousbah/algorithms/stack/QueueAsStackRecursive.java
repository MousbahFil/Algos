package com.mousbah.algorithms.stack;

import java.util.Stack;

public class QueueAsStackRecursive<T> {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        QueueAsStackRecursive<Integer> queue = new QueueAsStackRecursive<>(stack);
        System.out.println(queue.dequeue());
        System.out.println(stack.peek());
    }

    private Stack<T> stack;

    public QueueAsStackRecursive(Stack<T> stack) {
        this.stack = stack;
    }

    public Stack<T> getStack() {
        return stack;
    }

    public void setStack(Stack<T> stack) {
        this.stack = stack;
    }

    public T dequeue() {
        return dequeue(stack.pop());
    }

    private T dequeue(T previous) {
        if (stack.isEmpty()) {
            return previous;
        } else {
            T dequeue = dequeue(stack.pop());
            stack.push(previous);
            return dequeue;
        }
    }
}
