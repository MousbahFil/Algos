package com.mousbah.algorithms.dequeue;

import java.util.Arrays;

public class Dequeue<T> {


    private T[] data;
    private int head;
    private int tail;

    public static void main(String[] args) {

    }

    public Dequeue() {
        this.data = (T[]) new Object[5];
    }

    public void insertAtHead(T item) {
        increaseArray();
        shiftDataRight();
        data[head] = item;
        tail++;
    }

    public void insertAtTail(T item) {
        increaseArray();
        data[tail] = item;
        tail++;
    }

    public T pop() {
        T result = data[tail - 1];
        data[tail - 1] = null;
        tail--;
        return result;
    }

    public T removeFromHead() {
        T result = data[head];
        data[head] = null;
        head++;
        return result;
    }

    public String toString() {
        return Arrays.deepToString(data);
    }

    public int size() {
        return tail - head;
    }

    public T[] getData() {
        Object[] result = new Object[size()];
        for (int i = head; i < tail; i++) {
            result[i-head] = data[i];
        }
        return (T[]) result;
    }

    public T[] getRawData() {
        return Arrays.copyOf(data, data.length);
    }

    private void increaseArray() {
        if (size() == data.length - 1) {// Array is full
            increaseArraySize();
        }
    }

    private void increaseArraySize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        this.data = (T[]) newData;
    }

    private void shiftDataRight() {
        for (int i = tail + 1; i > head; i--) {
            data[i] = data[i - 1];
        }
    }


}
