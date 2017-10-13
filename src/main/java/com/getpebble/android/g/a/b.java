package com.getpebble.android.g.a;

import android.text.TextUtils;
import com.google.b.a.c;
import com.google.b.f;
import com.google.b.l;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class b {
    String a;
    String b;
    Map<String, a> c;
    private f d;

    public static class a {
        public final String a;
        public final a[] b;

        public static class a {
            @c(a = "type")
            public String a;
            @c(a = "value")
            public String b;
            @c(a = "from")
            public a c;
            @c(a = "to")
            public a d;

            public enum a {
                ;
                
                public final String descriptor;

                private a(java.lang.String r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r0 = this;
                    r0.<init>(r1, r2);
                    r0.descriptor = r3;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.g.a.b.a.a.a.<init>(java.lang.String, int, java.lang.String):void");
                }

                static com.getpebble.android.g.a.b.a.a.a from(java.lang.String r5) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r2 = values();
                    r3 = r2.length;
                    r0 = 0;
                    r1 = r0;
                L_0x0007:
                    if (r1 >= r3) goto L_0x001c;
                L_0x0009:
                    r0 = r2[r1];
                    r4 = r0.descriptor;
                    if (r4 == 0) goto L_0x0018;
                L_0x000f:
                    r4 = r0.descriptor;
                    r4 = r4.equals(r5);
                    if (r4 == 0) goto L_0x0018;
                L_0x0017:
                    return r0;
                L_0x0018:
                    r0 = r1 + 1;
                    r1 = r0;
                    goto L_0x0007;
                L_0x001c:
                    r0 = UNKNOWN;
                    goto L_0x0017;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.g.a.b.a.a.a.from(java.lang.String):com.getpebble.android.g.a.b$a$a$a");
                }
            }

            public java.lang.String toString() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r4 = this;
                r0 = "Type: %s Value: %s From: (%s) To: (%s)";
                r1 = 4;
                r1 = new java.lang.Object[r1];
                r2 = 0;
                r3 = r4.a;
                r1[r2] = r3;
                r2 = 1;
                r3 = r4.b;
                r1[r2] = r3;
                r2 = 2;
                r3 = r4.c;
                r1[r2] = r3;
                r2 = 3;
                r3 = r4.d;
                r1[r2] = r3;
                r0 = java.lang.String.format(r0, r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.g.a.b.a.a.toString():java.lang.String");
            }

            public com.getpebble.android.g.a.b.a.a.a a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r1 = this;
                r0 = r1.a;
                r0 = com.getpebble.android.g.a.b.a.a.a.from(r0);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.g.a.b.a.a.a():com.getpebble.android.g.a.b$a$a$a");
            }
        }

        static com.getpebble.android.g.a.b.a a(com.google.b.l r2, java.lang.String r3, com.google.b.f r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = new com.getpebble.android.g.a.b$a;
            r0 = com.getpebble.android.g.a.b.a.a[].class;
            r0 = r4.a(r2, r0);
            r0 = (com.getpebble.android.g.a.b.a.a[]) r0;
            r1.<init>(r3, r0);
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.g.a.b.a.a(com.google.b.l, java.lang.String, com.google.b.f):com.getpebble.android.g.a.b$a");
        }

        private a(java.lang.String r1, com.getpebble.android.g.a.b.a.a[] r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = this;
            r0.<init>();
            r0.a = r1;
            r0.b = r2;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.g.a.b.a.<init>(java.lang.String, com.getpebble.android.g.a.b$a$a[]):void");
        }
    }

    private Map<String, a> a() {
        return this.c;
    }

    b(a.a.a.a.a aVar, f fVar) {
        this.d = fVar;
        this.a = aVar.b();
        this.b = aVar.d();
        Map c = aVar.c();
        if (c == null) {
            throw new IllegalArgumentException("No entities found in WIT outcome.");
        }
        com.getpebble.android.common.b.a.f.e("NlpResult", "Nlp Result entities: " + c);
        this.c = new HashMap(c.size());
        for (Entry entry : c.entrySet()) {
            a a = a.a((l) entry.getValue(), (String) entry.getKey(), fVar);
            this.c.put(a.a, a);
        }
    }

    public a a(String str) {
        a aVar = (a) a().get(str);
        if (aVar == null) {
            com.getpebble.android.common.b.a.f.b("NlpResult", "getProperty: no Entity found for key " + str);
            return null;
        }
        a aVar2;
        if (aVar.b == null || aVar.b.length <= 0) {
            aVar2 = null;
        } else {
            aVar2 = aVar.b[0];
        }
        if (aVar2 == null) {
            com.getpebble.android.common.b.a.f.b("NlpResult", "getProperty: no property found for entity " + str);
            return null;
        } else if (!TextUtils.isEmpty(aVar2.a)) {
            return aVar2;
        } else {
            com.getpebble.android.common.b.a.f.b("NlpResult", "getProperty: no type found for the property " + str);
            return null;
        }
    }
}
