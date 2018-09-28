package com.mousbah.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.mousbah.algorithms.sort.SorterTestUtils.*;

public class MergeSortTest {

    @Test
    public void canSortEvenLenghtedArrayTest() {
        int[] result = MergeSort.sort(createUnsortedEvenLenghtArray());
        assertArrayEquals(createSortedEvenLengthArray(), result);
    }

    @Test
    public void canSortOddLenghtedArrayTest() {
        int[] result = MergeSort.sort(createUnsortedOddLengthArray());
        assertArrayEquals(createSortedOddLengthArray(), result);
    }


}