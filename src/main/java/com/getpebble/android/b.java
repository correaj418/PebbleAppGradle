package com.getpebble.android;

public class b {
    private static a a = a.ON;

    public enum a {
        ON,
        OFF;

        public boolean isOn() {
            return ON.equals(this);
        }
    }

    public static a a() {
        return a;
    }
}
