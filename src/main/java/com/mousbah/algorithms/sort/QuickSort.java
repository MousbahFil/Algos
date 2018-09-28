package com.mousbah.algorithms.sort;

public class QuickSort {

    public static void sort(int[] a){
        sort(a, 0 ,a.length-1);
    }

    private static void sort(int[] a, int left, int right){
            if(right==left){//Array of one item
                return;
            }
        int partitionIndex = partition(a, left, right);
        if(partitionIndex>left){
        sort(a, left, partitionIndex-1);
        }
        if(right>partitionIndex) {
            sort(a, partitionIndex + 1, right);
        }
    }


    private static int partition(int[]a, int left, int right){
        int pivot=a[left];
        int i=left+1;
        int j=i;

        while (j<=right){
            if(a[j]<pivot){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;
            }
            j++;
        }
        int temp=a[i-1];
        a[i-1]=pivot;
        a[left]=temp;
        return i-1;
    }
}
