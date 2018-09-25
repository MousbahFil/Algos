package com.mousbah.algorithms.data.compression.lzw;

import org.junit.Test;

import static org.junit.Assert.*;

public class LZWEncoderTest {

    @Test
    public void testEncode() {
        String input="ABABABA";
        assertTrue("Values do not match!", LZWEncoder.encode(input).equals("1235"));

    }
}