package com.google.c.a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class k {
    private a<String, Pattern> a;

    private static class a<K, V> {
        private LinkedHashMap<K, V> a;
        private int b;

        public a(int i) {
            this.b = i;
            this.a = new LinkedHashMap<K, V>(this, ((i * 4) / 3) + 1, 0.75f, true) {
                final /* synthetic */ a a;

                protected boolean removeEldestEntry(Entry<K, V> entry) {
                    return size() > this.a.b;
                }
            };
        }

        public synchronized V a(K k) {
            return this.a.get(k);
        }

        public synchronized void a(K k, V v) {
            this.a.put(k, v);
        }
    }

    public k(int i) {
        this.a = new a(i);
    }

    public Pattern a(String str) {
        Pattern pattern = (Pattern) this.a.a((Object) str);
        if (pattern != null) {
            return pattern;
        }
        pattern = Pattern.compile(str);
        this.a.a(str, pattern);
        return pattern;
    }
}
