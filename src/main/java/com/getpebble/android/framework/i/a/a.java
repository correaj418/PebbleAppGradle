package com.getpebble.android.framework.i.a;

import com.getpebble.android.notifications.a.b;
import java.util.List;

public abstract class a {
    public static final a a = new a() {
    };
    public static final a b = new a() {
    };
    public static final a c = new a() {
        public boolean a(b bVar) {
            List y = bVar.y();
            if (y == null || y.isEmpty()) {
                return true;
            }
            return false;
        }
    };
    public static final a d = new a() {
        public boolean a(b bVar) {
            return true;
        }
    };
    public static final a e = new a() {
        public boolean a(b bVar) {
            return true;
        }
    };
    public static final a f = new a() {
        public boolean a(b bVar) {
            return true;
        }
    };
    public static final a g = new a() {
        public boolean a(b bVar) {
            return true;
        }
    };
    public static final a h = new a() {
        public boolean a(b bVar) {
            return false;
        }
    };

    public static class a {
        public static a a(String str) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -2099846372:
                    if (str.equals("com.skype.raider")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -1651733025:
                    if (str.equals("com.viber.voip")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -1547699361:
                    if (str.equals("com.whatsapp")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -695601689:
                    if (str.equals("com.android.mms")) {
                        obj = 1;
                        break;
                    }
                    break;
                case -543674259:
                    if (str.equals("com.google.android.gm")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 0:
                    if (str.equals("")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 1515426419:
                    if (str.equals("com.google.android.talk")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1831574891:
                    if (str.equals("com.groupme.android")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    return a.f;
                case 1:
                    return a.a;
                case 2:
                    return a.c;
                case 3:
                    return a.g;
                case 4:
                    return a.e;
                case 5:
                    return a.d;
                case 6:
                    return a.h;
                default:
                    return a.b;
            }
        }
    }

    public boolean a(b bVar) {
        return true;
    }

    public long a() {
        return 750;
    }
}
