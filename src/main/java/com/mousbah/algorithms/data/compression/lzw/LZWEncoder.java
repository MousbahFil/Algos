package com.mousbah.algorithms.data.compression.lzw;

import java.util.HashMap;
import java.util.Map;

public class LZWEncoder {


    public static String encode(String text) {
        Map<String, Integer> codePoints = new HashMap<>();

        int counter = 1;
        for (char character : text.toCharArray()) {
            String key = String.valueOf(character);
            if (!codePoints.containsKey(key)) {
                codePoints.put(key, counter);
                counter++;
            }
        }

        int numberOfSkips;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i += numberOfSkips) {
            numberOfSkips = 0;

            while (i + numberOfSkips < text.length() && codePoints.containsKey(text.substring(i, i + numberOfSkips + 1))) {
                numberOfSkips++;
            }
            if (numberOfSkips == 1) {
                stringBuilder.append(codePoints.get(String.valueOf(text.charAt(i))));
            } else {
                stringBuilder.append(codePoints.get(text.substring(i, i + numberOfSkips)));
            }
            if (i + numberOfSkips + 1 < text.length()) {
                codePoints.put(text.substring(i, i + numberOfSkips + 1), counter++);
            }
        }
        return stringBuilder.toString();
    }

}
