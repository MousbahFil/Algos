/**
 *  Copyright Murex S.A.S., 2003-2018. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.mousbah.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class LongestRepeatedSubstring {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        LongestRepeatedSubstring longestRepeatedSubstring = new LongestRepeatedSubstring();
        System.out.println(longestRepeatedSubstring.getLongestRepeatedString("ab cde toto ab etotof"));
    }

    public String getLongestRepeatedString(String text) {
        List<String> suffixes = getSuffixes(text);
        Collections.sort(suffixes);
        String longestRepeatedSubstring = "";
        for (int i = 0; i < (suffixes.size() - 1); i++) {
            String longestCommonPrefix = getLongestCommonPrefix(Arrays.asList(suffixes.get(i), suffixes.get(i + 1)));
            if (longestCommonPrefix.length() > longestRepeatedSubstring.length()) {
                longestRepeatedSubstring = longestCommonPrefix;
            }
        }
        return longestRepeatedSubstring;
    }

    public String getLongestCommonPrefix(List<String> A) {
        List<String> prefixes = getPrefixes(A.get(0));
        String result = "";
        for (String prefix : prefixes) {
            if (isPrefix(prefix, A) && (prefix.length() > result.length())) {
                result = prefix;
            }
        }
        return result;
    }

    private List<String> getSuffixes(String text) {
        List<String> result = new ArrayList<>();
        for (int i = text.length() - 1; i >= 0; i--) {
            String substring = text.substring(i, text.length());
            System.out.println(String.format("Suffix: '%s'", substring));
            result.add(substring);
        }
        return result;
    }

    private boolean isPrefix(String prefix, List<String> A) {
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
