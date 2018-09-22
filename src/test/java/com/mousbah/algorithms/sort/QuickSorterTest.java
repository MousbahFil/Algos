package com.mousbah.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static  com.mousbah.algorithms.sort.SorterUtils.*;
public class QuickSorterTest {

    @Test
    public void canSortArrayTest() {
        int[] a=createUnsortedOddLengthArray();
        QuickSorter.sort(a);
        assertArrayEquals(createSortedOddLengthArray(), a);
    }

    @Test
    public void canSortEvenLenghtedArrayTest() {
        int[] a=createUnsortedEvenLenghtArray();
         QuickSorter.sort(a);
        assertArrayEquals(createSortedEvenLengthArray(), a);
    }
}