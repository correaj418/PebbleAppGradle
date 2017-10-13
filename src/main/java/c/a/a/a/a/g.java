package c.a.a.a.a;

import c.a.a.a.d;
import java.io.File;
import java.io.Serializable;

public class g extends a implements Serializable {
    private final String[] a;
    private final d b;

    public g(String str) {
        this(str, null);
    }

    public g(String str, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.a = new String[]{str};
        if (dVar == null) {
            dVar = d.SENSITIVE;
        }
        this.b = dVar;
    }

    public boolean accept(File file) {
        String name = file.getName();
        for (String checkEquals : this.a) {
            if (this.b.checkEquals(name, checkEquals)) {
                return true;
            }
        }
        return false;
    }

    public boolean accept(File file, String str) {
        for (String checkEquals : this.a) {
            if (this.b.checkEquals(str, checkEquals)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("(");
        if (this.a != null) {
            for (int i = 0; i < this.a.length; i++) {
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(this.a[i]);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
