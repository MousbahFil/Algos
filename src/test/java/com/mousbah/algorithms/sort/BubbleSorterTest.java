package com.mousbah.algorithms.sort;

import org.junit.Test;

import java.util.function.Function;

import static com.mousbah.algorithms.sort.SorterUtils.createSortedEvenLengthArray;
import static com.mousbah.algorithms.sort.SorterUtils.createUnsortedEvenLenghtArray;
import static org.junit.Assert.assertArrayEquals;

public class BubbleSorterTest {

    @Test
    public void canSortArrayTest() {
        sortArray(a -> {
            BubbleSorter.sort(a);
            return null;
        });
    }

    @Test
    public void canSortArrayUsingPlainOldLoopsTest() {
        sortArray(a -> {
            BubbleSorter.sortUsingLoop(a);
            return null;
        });
    }

    private void sortArray(Function<int[], Void> function) {
        int[] a = createUnsortedEvenLenghtArray();
        function.apply(a);
        assertArrayEquals(createSortedEvenLengthArray(), a);
    }
}