package com.mousbah.algorithms.data.compression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLength {


    public static String encode(String data) {
        StringBuilder sb = new StringBuilder();

        int numberOfSkips = 0;
        for (int i = 0; i < data.length(); i += numberOfSkips) {
            numberOfSkips = 1;
            while (i + numberOfSkips < data.length() && data.charAt(i) == data.charAt(i + numberOfSkips)) {
                numberOfSkips++;
            }
            if (numberOfSkips > 1) {
                sb.append(numberOfSkips);
            }
            sb.append(data.charAt(i));
        }
        return sb.toString();
    }

    public static String decode(String data) {
        Pattern pattern = Pattern.compile("([0-9])?([A-Z])");
        Matcher matcher = pattern.matcher(data);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String number = matcher.group(1);
            String stringItem = matcher.group(2);
            if (number != null && !number.isEmpty()) {
                int value = Integer.parseInt(number);
                for (int i = 0; i < value; i++) {
                    sb.append(stringItem);
                }
            } else {
                sb.append(stringItem);//In this case number is actually the character
            }
        }
        return sb.toString();
    }

}
