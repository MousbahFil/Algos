package com.mousbah.algorithms.sort;

import static com.mousbah.algorithms.sort.ArraySortingUtilities.getMaxIndex;
import static com.mousbah.algorithms.sort.ArraySortingUtilities.getMinIndex;

public class CountingSort {

    public static void sort(int[] a) {
        int[] countersArray = createCountersArray(a);
        int minimum=a[getMinIndex(a)];
        for (int i = 0; i < a.length; i++) {
            countersArray[a[i] - minimum] ++;
        }

        int index = 0;
        for (int i = 0; i < countersArray.length; i++) {
            if (countersArray[i] != 0) {
                for (int j = 0; j < countersArray[i]; j++) {
                    a[index] = i + minimum;
                    index++;
                }
            }
        }

    }

    private static int[] createCountersArray(int[] a) {
        int maximum = a[getMaxIndex(a)];
        int minimum = a[getMinIndex(a)];
        int size = maximum - minimum + 1;

        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        return result;
    }

}
