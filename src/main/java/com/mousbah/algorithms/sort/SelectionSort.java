package com.mousbah.algorithms.sort;

import static com.mousbah.algorithms.sort.ArraySortingUtilities.*;

public class SelectionSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int maxIndex = getMaxIndex(a, 0, a.length - 1 - i);
            int temp = a[maxIndex];
            a[maxIndex] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }


}
