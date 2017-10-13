package com.google.b;

public enum v {
    DEFAULT {
        public l serialize(Long l) {
            return new r((Number) l);
        }
    },
    STRING {
        public l serialize(Long l) {
            return new r(String.valueOf(l));
        }
    };

    public abstract l serialize(Long l);
}
