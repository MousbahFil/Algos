package com.mousbah.algorithms.sort;

import org.junit.Test;

import java.util.function.Function;

import static com.mousbah.algorithms.sort.SorterTestUtils.createSortedEvenLengthArray;
import static com.mousbah.algorithms.sort.SorterTestUtils.createUnsortedEvenLenghtArray;
import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void canSortArrayTest() {
        sortArray(a -> {
            BubbleSort.sort(a);
            return null;
        });
    }

    @Test
    public void canSortArrayUsingPlainOldLoopsTest() {
        sortArray(a -> {
            BubbleSort.sortUsingLoop(a);
            return null;
        });
    }

    private void sortArray(Function<int[], Void> function) {
        int[] a = createUnsortedEvenLenghtArray();
        function.apply(a);
        assertArrayEquals(createSortedEvenLengthArray(), a);
    }
}