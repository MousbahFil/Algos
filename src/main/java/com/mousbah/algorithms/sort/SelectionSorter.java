package com.mousbah.algorithms.sort;

public class SelectionSorter {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minimum = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minimum) {
                    minimum = a[j];
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
}
