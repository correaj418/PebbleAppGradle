package c.b.a.c;

class e {
    private final c[] a;
    private a[] b = new a[16];

    static class a {
        final Class<?> a;
        final c b;

        a(Class<?> cls, c cVar) {
            this.a = cls;
            this.b = cVar;
        }
    }

    e(c[] cVarArr) {
        this.a = cVarArr;
    }

    c a(Class<?> cls) {
        Object obj = this.b;
        int length = obj.length;
        int hashCode = cls == null ? 0 : cls.hashCode() & (length - 1);
        while (true) {
            a aVar = obj[hashCode];
            if (aVar == null) {
                break;
            } else if (aVar.a == cls) {
                return aVar.b;
            } else {
                int i = hashCode + 1;
                if (i >= length) {
                    hashCode = 0;
                } else {
                    hashCode = i;
                }
            }
        }
        c a = a(this, (Class) cls);
        a[] aVarArr = (a[]) obj.clone();
        aVarArr[hashCode] = new a(cls, a);
        for (hashCode = 0; hashCode < length; hashCode++) {
            if (aVarArr[hashCode] == null) {
                this.b = aVarArr;
                return a;
            }
        }
        int i2 = length << 1;
        a[] aVarArr2 = new a[i2];
        for (int i3 = 0; i3 < length; i3++) {
            a aVar2 = aVarArr[i3];
            Class cls2 = aVar2.a;
            hashCode = cls2 == null ? 0 : cls2.hashCode() & (i2 - 1);
            while (aVarArr2[hashCode] != null) {
                hashCode++;
                if (hashCode >= i2) {
                    hashCode = 0;
                }
            }
            aVarArr2[hashCode] = aVar2;
        }
        this.b = aVarArr2;
        return a;
    }

    int a() {
        return this.a.length;
    }

    e a(int i, c[] cVarArr) {
        c[] cVarArr2 = this.a;
        int length = cVarArr2.length;
        if (i >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (cVarArr != null) {
            cVarArr[0] = cVarArr2[i];
        }
        c[] cVarArr3 = new c[(length - 1)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4;
            if (i2 != i) {
                i4 = i3 + 1;
                cVarArr3[i3] = cVarArr2[i2];
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return new e(cVarArr3);
    }

    private static c a(e eVar, Class<?> cls) {
        c[] cVarArr = eVar.a;
        int length = cVarArr.length;
        int i = length;
        e eVar2 = eVar;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                break;
            }
            c cVar = cVarArr[i2];
            Class<?> a = cVar.a();
            if (a == cls) {
                return cVar;
            }
            if (a == null || !(cls == null || a.isAssignableFrom(cls))) {
                eVar2 = eVar2.a(i2, null);
                cVarArr = eVar2.a;
                length = cVarArr.length;
            }
            i = i2;
        }
        if (cls == null || length == 0) {
            return null;
        }
        if (length == 1) {
            return cVarArr[0];
        }
        c[] cVarArr2 = cVarArr;
        e eVar3 = eVar2;
        int i3 = length;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            Class a2 = cVarArr2[length].a();
            e eVar4 = eVar3;
            int i4 = length;
            length = i3;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                } else if (length != i4 && r4[length].a().isAssignableFrom(a2)) {
                    eVar4 = eVar4.a(length, null);
                    cVarArr2 = eVar4.a;
                    i3 = cVarArr2.length;
                    i4 = i3 - 1;
                }
            }
            length = i4;
            eVar3 = eVar4;
        }
        if (i3 == 1) {
            return cVarArr2[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find best converter for type \"");
        stringBuilder.append(cls.getName());
        stringBuilder.append("\" from remaining set: ");
        for (i4 = 0; i4 < i3; i4++) {
            c cVar2 = cVarArr2[i4];
            Class a3 = cVar2.a();
            stringBuilder.append(cVar2.getClass().getName());
            stringBuilder.append('[');
            stringBuilder.append(a3 == null ? null : a3.getName());
            stringBuilder.append("], ");
        }
        throw new IllegalStateException(stringBuilder.toString());
    }
}
