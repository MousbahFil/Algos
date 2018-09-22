package com.mousbah.algorithms.inversion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayInversionsCounterTest {


    private ArrayInversionsCounter arrayInversionsCounter;

    @Before
    public void setUp() throws Exception {
        arrayInversionsCounter = new ArrayInversionsCounter();
    }

    @Test
    public void canCountNumberOfInversionsTest() {
        int[] a=new int[]{1,2,6,5,7,3,12,10};
        int reached = arrayInversionsCounter.count(a);
        assertEquals(5,reached);
    }

    @Test
    public void canDetectNoInversionsTest() {
        int[] a=new int[]{1,2,3,4,5,6,7,8,9,20};
        int reached = arrayInversionsCounter.count(a);
        assertEquals(0,reached);
    }

    @Test
    public void canCountInversionsInReverselySortedArrayTest() {
        int[] a=new int[]{21,20,18,17,16,15};
        int reached = arrayInversionsCounter.count(a);
        assertEquals(15,reached);
    }
}