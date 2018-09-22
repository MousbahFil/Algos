package com.mousbah.algorithms.heaps.checker;

public class HeapChecker {

    public static void main(String[] args) {
        int[] heap = new int[]{100, 90, 80, 70, 60, 50, 40};
        System.out.println(isValidHeap(heap));
    }


    public static boolean isValidHeap(int[] heap) {
        return isValidParent(heap, 0);
    }

    private static boolean isValidParent(int[] heap, int parentIndex) {
        if (parentIndex >= heap.length) {
            return true;
        }
        int parent = heap[parentIndex];
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        boolean validLeft = leftChildIndex < heap.length ? parent > heap[leftChildIndex] : true;
        boolean validRight = rightChildIndex < heap.length ? parent > heap[rightChildIndex] : true;
        if (validLeft && validRight) {
            return isValidParent(heap, leftChildIndex) && isValidParent(heap, rightChildIndex);
        } else {
            return false;
        }
    }


}
