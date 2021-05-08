package com.xander.movieplayer.util;


import com.xander.movieplayer.exception.CheckException;

public class CheckUtil {
    public static void check(boolean condition, String message) {
        if (!condition) {
            fail(message);
        }
    }

    private static void fail(String message) {
        throw new CheckException(message);
    }
}
