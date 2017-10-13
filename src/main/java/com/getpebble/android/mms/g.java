package com.getpebble.android.mms;

public class g {
    public static boolean a(String str) {
        return str.equalsIgnoreCase("image/jpg") || str.equalsIgnoreCase("image/jpeg") || str.equalsIgnoreCase("image/png") || str.equalsIgnoreCase("image/gif") || str.equalsIgnoreCase("image/bmp");
    }

    public static boolean b(String str) {
        return str.equalsIgnoreCase("text/plain");
    }

    public static boolean c(String str) {
        if (str.equalsIgnoreCase("audio/aac") || str.equalsIgnoreCase("audio/mp4") || str.equalsIgnoreCase("audio/m4a") || str.equalsIgnoreCase("audio/mpeg") || str.equalsIgnoreCase("audio/mp1") || str.equalsIgnoreCase("audio/mp2") || str.equalsIgnoreCase("audio/mp3") || str.equalsIgnoreCase("audio/mpg") || str.equalsIgnoreCase("audio/ogg") || str.equalsIgnoreCase("audio/oga") || str.equalsIgnoreCase("audio/3gpp") || str.equalsIgnoreCase("audio/wav") || str.equalsIgnoreCase("audio/webm")) {
            return true;
        }
        return false;
    }

    public static boolean d(String str) {
        if (str.equalsIgnoreCase("video/mp4") || str.equalsIgnoreCase("video/m4v") || str.equalsIgnoreCase("video/3gpp") || str.equalsIgnoreCase("video/ogg") || str.equalsIgnoreCase("video/ogv") || str.equalsIgnoreCase("video/webm")) {
            return true;
        }
        return false;
    }

    public static int a(Mms mms) {
        int i = 0;
        if (mms.e) {
            i = 1;
        }
        if (mms.g) {
            i++;
        }
        if (mms.c > 0) {
            return i + 1;
        }
        return i;
    }
}
