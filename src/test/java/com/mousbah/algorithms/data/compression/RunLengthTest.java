package com.mousbah.algorithms.data.compression;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunLengthTest {

    public static final String ENCODED = "A3B2C3D4E3A";
    public static final String DECODED = "ABBBCCDDDEEEEAAA";

    @Test
    public void testEncode() {
        String text= DECODED;
        String result=RunLength.encode(text);
        assertTrue("Found mismatch", result.equals(ENCODED));
    }

    @Test
    public void testDecode() {
        String decoded = RunLength.decode(ENCODED);
        System.out.println(decoded);
        assertTrue("Found mismatch", decoded.equals(DECODED));
    }
}