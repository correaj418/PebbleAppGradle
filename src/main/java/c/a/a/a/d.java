package c.a.a.a;

import java.io.Serializable;

public enum d implements Serializable {
    SENSITIVE("Sensitive", true),
    INSENSITIVE("Insensitive", false);
    
    private static final long serialVersionUID = -6343169151696340687L;
    private final String name;
    private final transient boolean sensitive;

    static {
        boolean z;
        SENSITIVE = new d("SENSITIVE", 0, "Sensitive", true);
        INSENSITIVE = new d("INSENSITIVE", 1, "Insensitive", false);
        String str = "SYSTEM";
        String str2 = "System";
        if (c.a()) {
            z = false;
        } else {
            z = true;
        }
        SYSTEM = new d(str, 2, str2, z);
        $VALUES = new d[]{SENSITIVE, INSENSITIVE, SYSTEM};
    }

    public static d forName(String str) {
        for (d dVar : values()) {
            if (dVar.getName().equals(str)) {
                return dVar;
            }
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    private d(String str, boolean z) {
        this.name = str;
        this.sensitive = z;
    }

    private Object readResolve() {
        return forName(this.name);
    }

    public String getName() {
        return this.name;
    }

    public boolean isCaseSensitive() {
        return this.sensitive;
    }

    public int checkCompareTo(String str, String str2) {
        if (str != null && str2 != null) {
            return this.sensitive ? str.compareTo(str2) : str.compareToIgnoreCase(str2);
        } else {
            throw new NullPointerException("The strings must not be null");
        }
    }

    public boolean checkEquals(String str, String str2) {
        if (str != null && str2 != null) {
            return this.sensitive ? str.equals(str2) : str.equalsIgnoreCase(str2);
        } else {
            throw new NullPointerException("The strings must not be null");
        }
    }

    public boolean checkStartsWith(String str, String str2) {
        return str.regionMatches(!this.sensitive, 0, str2, 0, str2.length());
    }

    public boolean checkEndsWith(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.sensitive, str.length() - length, str2, 0, length);
    }

    public int checkIndexOf(String str, int i, String str2) {
        int length = str.length() - str2.length();
        if (length >= i) {
            for (int i2 = i; i2 <= length; i2++) {
                if (checkRegionMatches(str, i2, str2)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public boolean checkRegionMatches(String str, int i, String str2) {
        return str.regionMatches(!this.sensitive, i, str2, 0, str2.length());
    }

    public String toString() {
        return this.name;
    }
}
