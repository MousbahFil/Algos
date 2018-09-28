package com.mousbah.algorithms.sort;

import org.junit.Test;

import static com.mousbah.algorithms.sort.SorterTestUtils.*;

import static org.junit.Assert.*;

public class CountingSortTest {

    @Test
    public void testSortEvenLengthedArray() {
        int[] array = createUnsortedEvenLenghtArray();
        CountingSort.sort(array);
        assertArrayEquals(createSortedEvenLengthArray(), array);
    }

    @Test
    public void testSortOddLengthedArray() {
        int[] array = createUnsortedOddLengthArray();
        CountingSort.sort(array);
        assertArrayEquals(createSortedOddLengthArray(), array);
    }
}