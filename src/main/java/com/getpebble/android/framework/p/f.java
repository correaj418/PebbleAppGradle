package com.getpebble.android.framework.p;

import android.text.TextUtils;
import com.getpebble.android.framework.g.aj;
import com.getpebble.android.h.p;
import java.nio.ByteOrder;
import java.util.UUID;

public class f {
    private com.getpebble.android.g.a.c a = a();
    private b b;
    private a c;
    private com.getpebble.android.g.a d = new com.getpebble.android.g.a(this) {
        final /* synthetic */ f a;

        {
            this.a = r1;
        }

        public void a(short s, com.getpebble.android.g.a.a.a aVar, String str) {
            if (this.a.b == null) {
                com.getpebble.android.common.b.a.f.b("NlpClient", "mNlpListener: onFailed: return mCurrentNlpSessionSetup is null");
            } else if (this.a.b.b != s) {
                com.getpebble.android.common.b.a.f.b("NlpClient", "mNlpListener: onFailed: return wrong sessionId");
            } else {
                a(s, aVar, null);
                if (this.a.c != null) {
                    this.a.c.a(this.a.b.b, com.getpebble.android.framework.g.ak.c.ERROR_INVALID_RESPONSE, null, this.a.b.c, this.a.b.d);
                }
                this.a.a.b(this);
            }
        }

        public void a(short s, com.getpebble.android.g.a.b bVar) {
            if (this.a.b == null) {
                com.getpebble.android.common.b.a.f.b("NlpClient", "mNlpListener: onFailed: return mCurrentNlpSessionSetup is null");
            } else if (this.a.b.b != s) {
                com.getpebble.android.common.b.a.f.b("NlpClient", "mNlpListener: onFailed: return wrong sessionId");
            } else {
                a(s, null, bVar);
                if (this.a.c != null) {
                    this.a.c.a(this.a.b.b, com.getpebble.android.framework.g.ak.c.SUCCESS, bVar, this.a.b.c, this.a.b.d);
                }
                this.a.a.b(this);
            }
        }

        private void a(short s, com.getpebble.android.g.a.a.a aVar, com.getpebble.android.g.a.b bVar) {
            com.getpebble.android.common.b.a.a.c.a(s, aVar == null ? null : aVar.name().toLowerCase(), bVar, this.a.b.d);
        }
    };

    public interface a {
        void a(short s, com.getpebble.android.framework.g.ak.c cVar, com.getpebble.android.g.a.b bVar, aj ajVar, UUID uuid);
    }

    private static class b {
        private final c a;
        private final short b;
        private final aj c;
        private final UUID d;
        private final int e;
        private final String f;
        private final String g;
        private final String h;
        private final int i;
        private final ByteOrder j;

        private b(c cVar, short s, aj ajVar, UUID uuid, String str, String str2) {
            this(cVar, s, ajVar, uuid, str, str2, null, 0, 0, null);
        }

        private b(c cVar, short s, aj ajVar, UUID uuid, String str, String str2, String str3, int i, int i2, ByteOrder byteOrder) {
            this.a = cVar;
            this.b = s;
            this.c = ajVar;
            this.d = uuid;
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.i = i;
            this.e = i2;
            this.j = byteOrder;
        }

        private static b b(short s, aj ajVar, UUID uuid, String str, String str2) {
            return new b(c.TEXT_TO_NLU, s, ajVar, uuid, str, str2);
        }
    }

    private enum c {
        VOICE_TO_NLU,
        TEXT_TO_NLU
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    private com.getpebble.android.g.a.c a() {
        return com.getpebble.android.g.a.c.a(com.getpebble.android.common.a.K(), p.a());
    }

    public boolean a(short s, aj ajVar, UUID uuid, String str, String str2, k kVar) {
        String a = a(kVar);
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        com.getpebble.android.common.b.a.f.d("NlpClient", "Dictation transcript for NLP request: " + com.getpebble.android.common.b.b.a.a((Object) a));
        b a2 = b.b(s, ajVar, uuid, str, str2);
        boolean a3 = this.a.a(s, a);
        if (!a3) {
            return a3;
        }
        this.b = a2;
        this.a.a(this.d);
        return a3;
    }

    private static String a(k kVar) {
        int i = 0;
        if (kVar == null) {
            return null;
        }
        com.getpebble.android.framework.p.k.a[][] aVarArr = kVar.c;
        if (aVarArr == null || aVarArr.length == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        com.getpebble.android.framework.p.k.a[] aVarArr2 = aVarArr[0];
        int length = aVarArr2.length;
        while (i < length) {
            com.getpebble.android.framework.p.k.a aVar = aVarArr2[i];
            try {
                if (aVar.b.charAt(0) == '\b') {
                    stringBuilder.append(aVar.b.substring(1));
                } else {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(aVar.b);
                }
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.b("NlpClient", "error: ", e);
            }
            i++;
        }
        Object stringBuilder2 = stringBuilder.toString();
        com.getpebble.android.common.b.a.f.e("NlpClient", "extractTranscript: transcript = " + com.getpebble.android.common.b.b.a.a(stringBuilder2));
        return stringBuilder2;
    }
}
