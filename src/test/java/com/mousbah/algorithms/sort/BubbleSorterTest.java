package com.mousbah.algorithms.sort;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.mousbah.algorithms.sort.SorterUtils.*;

public class BubbleSorterTest {

    @Test
    public void canSortArrayTest() {
        int[] a=createUnsortedEvenLenghtArray();
         BubbleSorter.sort(a);
        assertArrayEquals(createSortedEvenLengthArray(), a);
    }
}