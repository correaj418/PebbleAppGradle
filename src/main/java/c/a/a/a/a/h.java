package c.a.a.a.a;

import java.io.File;
import java.io.Serializable;

public class h extends a implements Serializable {
    private final f a;

    public h(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("The filter must not be null");
        }
        this.a = fVar;
    }

    public boolean accept(File file) {
        return !this.a.accept(file);
    }

    public boolean accept(File file, String str) {
        return !this.a.accept(file, str);
    }

    public String toString() {
        return super.toString() + "(" + this.a.toString() + ")";
    }
}
