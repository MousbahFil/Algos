package com.mousbah.algorithms.sort;

public class InsertionSorter {

    public static void sort(int[] a){
        for(int i=1; i<a.length; i++){
            for(int j=0; j<i;j++){
                if(a[i]<a[j]){
                    int temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
        }
    }
}
