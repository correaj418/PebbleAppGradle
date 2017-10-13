package com.google.b;

import com.google.b.b.j;
import com.google.b.d.a;
import com.google.b.d.b;
import java.io.Reader;
import java.io.StringReader;

public final class q {
    public l a(String str) {
        return a(new StringReader(str));
    }

    public l a(Reader reader) {
        try {
            a aVar = new a(reader);
            l a = a(aVar);
            if (a.k() || aVar.f() == b.END_DOCUMENT) {
                return a;
            }
            throw new u("Did not consume the entire document.");
        } catch (Throwable e) {
            throw new u(e);
        } catch (Throwable e2) {
            throw new m(e2);
        } catch (Throwable e22) {
            throw new u(e22);
        }
    }

    public l a(a aVar) {
        boolean q = aVar.q();
        aVar.a(true);
        try {
            l a = j.a(aVar);
            aVar.a(q);
            return a;
        } catch (Throwable e) {
            throw new p("Failed parsing JSON source: " + aVar + " to Json", e);
        } catch (Throwable e2) {
            throw new p("Failed parsing JSON source: " + aVar + " to Json", e2);
        } catch (Throwable th) {
            aVar.a(q);
        }
    }
}
