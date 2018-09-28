/**
 *  Copyright Murex S.A.S., 2003-2018. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.mousbah.algorithms.arrays;

import java.util.Arrays;


public class ArrayReverser {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Integer[] heap = new Integer[] { 1, 3, 2, 5, 4, 7, 6, 10, 11, 13, 12, 19, 14, 15, 13 };
        reverse(heap);
        System.out.println(Arrays.toString(heap));
    }

    private static <T> void  reverse(T[] array){
        int middleIndex=array.length/2;
        int size=array.length;
        for (int i=0; i<=middleIndex; i++){
            T temp=array[i];
            array[i]=array[size-1-i];
            array[size-1-i]=temp;
        }
    }


}
