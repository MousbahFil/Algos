/**
 *  Copyright Murex S.A.S., 2003-2018. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.mousbah.algorithms;

public class BruteForceStringSearch {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    private String text;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public BruteForceStringSearch(String text) {
        this.text = text;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        String text = "Hello this is a sample text used for pattern matching";
        BruteForceStringSearch bruteForceStringSearch = new BruteForceStringSearch(text);
        System.out.println(bruteForceStringSearch.indexOf("matching"));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int indexOf(String pattern) {
        int length = text.length();
        for (int i = 0; i < length; i++) {
            boolean foundMatch = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    foundMatch = false;
                    break;
                }
            }
            if (foundMatch) {
                return i;
            }
        }
        return -1;
    }

}
