package com.mousbah.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.mousbah.algorithms.sort.SorterUtils.*;

public class InsertionSorterTest {
    @Test
    public void canSortArrayTest() {
        int[] a = createUnsortedEvenLenghtArray();
        InsertionSorter.sort(a);
        assertArrayEquals(createSortedEvenLengthArray(), a);
    }
}