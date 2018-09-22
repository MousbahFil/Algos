package com.mousbah.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.mousbah.algorithms.sort.SorterUtils.*;

public class SelectionSorterTest {

    @Test
    public void canSortArrayTest() {
        int[] a=createUnsortedOddLengthArray();
         SelectionSorter.sort(a);
        assertArrayEquals(createSortedOddLengthArray(), a);
    }

    @Test
    public void canSortArrayOfIdenticalElementsTest() {
        int[] a= createArrayOfIdenticalElements();
        SelectionSorter.sort(a);
        assertArrayEquals(a, a);
    }

}