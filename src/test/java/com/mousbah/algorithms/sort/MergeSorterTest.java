package com.mousbah.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.mousbah.algorithms.sort.SorterUtils.*;

public class MergeSorterTest {

    @Test
    public void canSortEvenLenghtedArrayTest() {
        int[] result = MergeSorter.sort(createUnsortedEvenLenghtArray());
        assertArrayEquals(createSortedEvenLengthArray(), result);
    }

    @Test
    public void canSortOddLenghtedArrayTest() {
        int[] result = MergeSorter.sort(createUnsortedOddLengthArray());
        assertArrayEquals(createSortedOddLengthArray(), result);
    }


}