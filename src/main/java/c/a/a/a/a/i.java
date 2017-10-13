package c.a.a.a.a;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class i extends a implements Serializable {
    private final List<f> a;

    public i() {
        this.a = new ArrayList();
    }

    public i(List<f> list) {
        if (list == null) {
            this.a = new ArrayList();
        } else {
            this.a = new ArrayList(list);
        }
    }

    public boolean accept(File file) {
        for (f accept : this.a) {
            if (accept.accept(file)) {
                return true;
            }
        }
        return false;
    }

    public boolean accept(File file, String str) {
        for (f accept : this.a) {
            if (accept.accept(file, str)) {
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
            for (int i = 0; i < this.a.size(); i++) {
                String str;
                if (i > 0) {
                    stringBuilder.append(",");
                }
                Object obj = this.a.get(i);
                if (obj == null) {
                    str = "null";
                } else {
                    str = obj.toString();
                }
                stringBuilder.append(str);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
