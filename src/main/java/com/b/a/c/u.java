package com.b.a.c;

import java.util.Hashtable;
import java.util.Locale;

public enum u {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1") {
        public boolean needsSpdyConnection() {
            return true;
        }
    },
    HTTP_2("h2-13") {
        public boolean needsSpdyConnection() {
            return true;
        }
    };
    
    private static final Hashtable<String, u> protocols = null;
    private final String protocol;

    static {
        protocols = new Hashtable();
        protocols.put(HTTP_1_0.toString(), HTTP_1_0);
        protocols.put(HTTP_1_1.toString(), HTTP_1_1);
        protocols.put(SPDY_3.toString(), SPDY_3);
        protocols.put(HTTP_2.toString(), HTTP_2);
    }

    private u(String str) {
        this.protocol = str;
    }

    public static u get(String str) {
        if (str == null) {
            return null;
        }
        return (u) protocols.get(str.toLowerCase(Locale.US));
    }

    public String toString() {
        return this.protocol;
    }

    public boolean needsSpdyConnection() {
        return false;
    }
}
