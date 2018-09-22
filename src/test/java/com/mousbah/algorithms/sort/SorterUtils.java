package com.mousbah.algorithms.sort;

import static org.junit.Assert.assertArrayEquals;

public class SorterUtils {

    public static int[] createUnsortedEvenLenghtArray() {
        return new int[]{1,7,6,12,5,9,6,11,153,155,154,158,156,156,161,160};
    }
    public static int[] createSortedEvenLengthArray() {
        return new int[]{1,5,6,6,7,9,11,12,153,154,155,156,156,158,160,161};
    }

    public static int[] createUnsortedOddLengthArray() {
        return new int[]{1,7,6,12,5,9,6,11,153,155,154,158,156,156,161};
    }

    public static int[] createSortedOddLengthArray() {
        return new int[]{1,5,6,6,7,9,11,12,153,154,155,156,156,158,161};
    }

    public static int[] createArrayOfIdenticalElements() {
        return new int[]{4,4,4};
    }

}
