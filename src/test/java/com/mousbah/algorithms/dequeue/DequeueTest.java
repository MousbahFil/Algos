package com.mousbah.algorithms.dequeue;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class DequeueTest {

    @Test
    public void testCanInsertAndRemove() {
        Dequeue<Integer> dequeue=new Dequeue<>();
        IntStream.rangeClosed(1,12).forEach(dequeue::insertAtHead);
        assertArrayEquals(new Integer[]{12,11,10,9,8,7,6,5,4,3,2,1,null,null,null,null,null,null,null,null},dequeue.getRawData());
        assertArrayEquals(new Integer[]{12,11,10,9,8,7,6,5,4,3,2,1},dequeue.getData());
        assertTrue("Found mismatch", dequeue.pop()==1);
        assertTrue("Found mismatch", dequeue.pop()==2);
        assertTrue("Found mismatch", dequeue.pop()==3);

        assertTrue("Found mismatch", dequeue.removeFromHead()==12);
        assertTrue("Found mismatch", dequeue.removeFromHead()==11);
        assertTrue("Found mismatch", dequeue.removeFromHead()==10);

        assertTrue("Found mismatch", dequeue.pop()==4);
        assertTrue("Found mismatch", dequeue.pop()==5);
        assertTrue("Found mismatch", dequeue.pop()==6);

        assertTrue("Found mismatch", dequeue.size()==3);

        assertArrayEquals(new Integer[]{null,null,null,9,8,7,null,null,null,null,null,null,null,null,null,null,null,null,null,null},dequeue.getRawData());
        assertArrayEquals(new Integer[]{9,8,7},dequeue.getData());

    }
}