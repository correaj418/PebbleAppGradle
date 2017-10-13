package c.b.a.e;

import java.io.IOException;

public class i {
    private static final double a = Math.log(10.0d);

    public static void a(StringBuffer stringBuffer, int i, int i2) {
        try {
            a((Appendable) stringBuffer, i, i2);
        } catch (IOException e) {
        }
    }

    public static void a(Appendable appendable, int i, int i2) {
        if (i < 0) {
            appendable.append('-');
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                while (i2 > 10) {
                    appendable.append('0');
                    i2--;
                }
                appendable.append("2147483648");
                return;
            }
        }
        if (i < 10) {
            while (i2 > 1) {
                appendable.append('0');
                i2--;
            }
            appendable.append((char) (i + 48));
        } else if (i < 100) {
            while (i2 > 2) {
                appendable.append('0');
                i2--;
            }
            r0 = ((i + 1) * 13421772) >> 27;
            appendable.append((char) (r0 + 48));
            appendable.append((char) (((i - (r0 << 3)) - (r0 << 1)) + 48));
        } else {
            if (i < 1000) {
                r0 = 3;
            } else if (i < 10000) {
                r0 = 4;
            } else {
                r0 = ((int) (Math.log((double) i) / a)) + 1;
            }
            while (i2 > r0) {
                appendable.append('0');
                i2--;
            }
            appendable.append(Integer.toString(i));
        }
    }

    public static void a(Appendable appendable, int i) {
        if (i < 0) {
            appendable.append('-');
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                appendable.append("2147483648");
                return;
            }
        }
        if (i < 10) {
            appendable.append((char) (i + 48));
        } else if (i < 100) {
            int i2 = ((i + 1) * 13421772) >> 27;
            appendable.append((char) (i2 + 48));
            appendable.append((char) (((i - (i2 << 3)) - (i2 << 1)) + 48));
        } else {
            appendable.append(Integer.toString(i));
        }
    }

    static int a(CharSequence charSequence, int i) {
        int charAt = charSequence.charAt(i) - 48;
        return (((charAt << 1) + (charAt << 3)) + charSequence.charAt(i + 1)) - 48;
    }

    static String a(String str, int i) {
        String str2;
        int i2 = i + 32;
        if (str.length() <= i2 + 3) {
            str2 = str;
        } else {
            str2 = str.substring(0, i2).concat("...");
        }
        if (i <= 0) {
            return "Invalid format: \"" + str2 + '\"';
        }
        if (i >= str.length()) {
            return "Invalid format: \"" + str2 + "\" is too short";
        }
        return "Invalid format: \"" + str2 + "\" is malformed at \"" + str2.substring(i) + '\"';
    }
}
