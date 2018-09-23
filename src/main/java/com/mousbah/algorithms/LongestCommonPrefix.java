/**
 * Copyright Murex S.A.S., 2003-2018. All Rights Reserved.
 * <p>
 * This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 * express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.mousbah.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LongestCommonPrefix {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("abcdefgh", "abgghijk", "abcefgh","ab"));
        System.out.println(new LongestCommonPrefix().getLongestCommonPrefix(strings));
    }

    public String getLongestCommonPrefix(ArrayList<String> input) {
        List<String> sortedList = input.stream().sorted((s1, s2) -> s1.length() < s2.length() ? -1 : 1).collect(Collectors.toList());
        String prefix = sortedList.get(0);
        for (int i = 1; i < prefix.length(); i++) {
            for (int j = 1; j < sortedList.size(); j++) {
                if (sortedList.get(j).charAt(i) != prefix.charAt(i)) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

    private boolean isPrefix(String prefix, ArrayList<String> A) {
        for (int i = 1; i < A.size(); i++) {
            if (!A.get(i).startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    private List<String> getPrefixes(String text) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            result.add(text.substring(0, i + 1));
        }
        return result;
    }

}
