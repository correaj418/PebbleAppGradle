package c.a.a.a.b;

import java.io.Serializable;
import java.io.Writer;

public class a extends Writer implements Serializable {
    private final StringBuilder a;

    public a() {
        this.a = new StringBuilder();
    }

    public a(int i) {
        this.a = new StringBuilder(i);
    }

    public Writer append(char c) {
        this.a.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.a.append(charSequence, i, i2);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(String str) {
        if (str != null) {
            this.a.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.a.append(cArr, i, i2);
        }
    }

    public String toString() {
        return this.a.toString();
    }
}
