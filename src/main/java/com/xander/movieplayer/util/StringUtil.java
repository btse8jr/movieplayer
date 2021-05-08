package com.xander.movieplayer.util;

import java.util.Random;

public final class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String randomString(char start, char end, int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char ch = (char) (random.nextInt(end - start + 1) + start);
            builder.append(ch);
        }
        return builder.toString();
    }
}
