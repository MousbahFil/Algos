/**
 *  Copyright Murex S.A.S., 2003-2018. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.mousbah.algorithms;

import java.util.HashMap;
import java.util.Map;


public class TwoSumProblemDynamicProgramming {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    private int[] array;
    private int sum;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public TwoSumProblemDynamicProgramming(int[] array, int sum) {
        this.array = array;
        this.sum = sum;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5 };
        TwoSumProblemDynamicProgramming solver = new TwoSumProblemDynamicProgramming(array, 7);
        solver.solve();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private void solve() {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            data.put(array[i], array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if (data.containsKey(sum - array[i])) {
                System.out.println(String.format("%s + %s = 7", array[i], data.get(sum - array[i])));
            }
        }
    }
}
