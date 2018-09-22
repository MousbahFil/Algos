package com.mousbah.algorithms.sort;

public class ArraySortingUtilities {

    public static int getMinIndex(int[] a) {
        return  getMinIndex(a,0, a.length-1);
    }

    public static int getMinIndex(int[] a, int start, int end) {
        int minIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }


    public static int getMaxIndex(int[] a) {
        return getMaxIndex(a, 0, a.length - 1);
    }

    public static int getMaxIndex(int[] a, int startIndex, int endIndex) {
        int maxIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
