package com.mousbah.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.mousbah.algorithms.sort.SorterTestUtils.*;

public class InsertionSortTest {
    @Test
    public void canSortArrayTest() {
        int[] a = createUnsortedEvenLenghtArray();
        InsertionSort.sort(a);
        assertArrayEquals(createSortedEvenLengthArray(), a);
    }
}