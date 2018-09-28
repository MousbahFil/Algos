package com.mousbah.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.mousbah.algorithms.sort.SorterTestUtils.*;

public class SelectionSortTest {

    @Test
    public void canSortArrayTest() {
        int[] a=createUnsortedOddLengthArray();
         SelectionSort.sort(a);
        assertArrayEquals(createSortedOddLengthArray(), a);
    }

    @Test
    public void canSortArrayOfIdenticalElementsTest() {
        int[] a= createArrayOfIdenticalElements();
        SelectionSort.sort(a);
        assertArrayEquals(a, a);
    }

}