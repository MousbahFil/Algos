package com.mousbah.algorithms.sort;

public class ShellSort {

    public static void sort(int[] a) {
        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {

            for (int i = 0; i < a.length; i++) {

                int j = a.length - 1 - i;
                while (j >= 0 && j - gap >= 0) {
                    if (a[j] < a[j - gap]) {
                        int temp = a[j];
                        a[j] = a[j - gap];
                        a[j - gap] = temp;
                    }
                    j -= gap;
                }
            }
        }
    }
}
