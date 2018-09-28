package com.mousbah.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.mousbah.algorithms.sort.SorterTestUtils.*;
public class QuickSortTest {

    @Test
    public void canSortArrayTest() {
        int[] a=createUnsortedOddLengthArray();
        QuickSort.sort(a);
        assertArrayEquals(createSortedOddLengthArray(), a);
    }

    @Test
    public void canSortEvenLenghtedArrayTest() {
        int[] a=createUnsortedEvenLenghtArray();
         QuickSort.sort(a);
        assertArrayEquals(createSortedEvenLengthArray(), a);
    }
}