/**
 *  Copyright Murex S.A.S., 2003-2018. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.mousbah.algorithms.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class BoyerMooreAlgorithm {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    private String text;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public BoyerMooreAlgorithm(String text) {
        this.text = text;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        String text = "Hello this is a sample text used for pattern matching";
        BoyerMooreAlgorithm boyerMooreAlgorithm = new BoyerMooreAlgorithm(text);
        System.out.println(boyerMooreAlgorithm.indexOf("sample"));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int indexOf(String pattern) {
        Map<Character, Integer> badPointsTable = createBadPointsTable(pattern);
        int numberOfSkips = 0;
        for (int i = 0; i <= (text.length() - pattern.length()); i += numberOfSkips) {
            numberOfSkips = 0;
            for (int j = pattern.length() - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    numberOfSkips = badPointsTable.getOrDefault(pattern.charAt(j), pattern.length());
                    break;
                }
            }
            if (numberOfSkips == 0) {
                return i;
            }
        }
        return -1;
    }

    private Map<Character, Integer> createBadPointsTable(String pattern) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int patternLength = pattern.length();
        IntStream.range(0,patternLength).forEach(i -> map.put(pattern.charAt(i), Math.max(1, patternLength - 1 - i)));
        return map;
    }

}
