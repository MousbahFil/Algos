package com.mousbah.algorithms.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BubbleSorter {

    public static void sort(int[] a){
        IntStream.range(0, a.length).forEach(i-> IntStream.range(0, a.length-i-1).forEach(j ->{
            if(a[j]>a[j+1]){
                int temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }));
    }

    private static int[] sortUsingLoop(int[] a) {
        for(int i=0; i< a.length; i++){
            for(int j=a.length-1; j>i ;j--){
                if(a[j]<a[j-1]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }
        return a;
    }
}
