package com.mousbah.algorithms.inversion;

import java.util.Arrays;

public class ArrayInversionsCounter {


    private int count;

    public int count(int[] a){
        sort(a);
        return count;
    }

    public  int[] sort(int[] a){
        if(a.length<=1){
            return a;
        }
        int[] left= Arrays.copyOfRange(a, 0, a.length/2);
        int [] right=Arrays.copyOfRange(a, a.length/2, a.length);
        left= sort(left);
        right= sort(right);
        return merge(left,right);
    }

    private  int[] merge(int[] left, int[] right){
        int leftCounter=0;
        int rightCounter=0;
        int[] result=new int[left.length+ right.length];
        for (int i=0; i<result.length; i++){
            if(left[leftCounter]<=right[rightCounter]){
                result[i]=left[leftCounter];
                leftCounter++;
            }else if(right[rightCounter]< left[leftCounter]){
                result[i]=right[rightCounter];
                rightCounter++;
                count +=left.length-leftCounter;
            }

            if(leftCounter==left.length){
                for(int j=rightCounter; j<right.length;j++){
                    result[++i]=right[j];
                }
            }else if(rightCounter==right.length){
                for (int j=leftCounter;j<left.length;j++){
                    result[++i]=left[j];
                }
            }

        }
        return result;
    }
}
