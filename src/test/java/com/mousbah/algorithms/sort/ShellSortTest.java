package com.mousbah.algorithms.sort;

import org.junit.Test;

import static com.mousbah.algorithms.sort.SorterUtils.*;

import static org.junit.Assert.*;

public class ShellSortTest {

    @Test
    public void testSortEvenLengthedArray() {
        int[] array = createUnsortedEvenLenghtArray();
        ShellSort.sort(array);
        assertArrayEquals(createSortedEvenLengthArray(), array);
    }

    @Test
    public void testSortOddLengthedArray() {
        int[] array = createUnsortedOddLengthArray();
        ShellSort.sort(array);
        assertArrayEquals(createSortedOddLengthArray(), array);
    }
}