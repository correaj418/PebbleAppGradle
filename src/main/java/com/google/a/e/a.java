package com.google.a.e;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.f;
import com.google.a.a.g;
import com.google.a.b.ae;
import com.google.a.b.al;
import com.google.a.b.ay;
import com.google.a.b.bb;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class a {
    public static final a A = a("image", "webp");
    public static final a B = a("audio", "mp4");
    public static final a C = a("audio", "mpeg");
    public static final a D = a("audio", "ogg");
    public static final a E = a("audio", "webm");
    public static final a F = a("video", "mp4");
    public static final a G = a("video", "mpeg");
    public static final a H = a("video", "ogg");
    public static final a I = a("video", "quicktime");
    public static final a J = a("video", "webm");
    public static final a K = a("video", "x-ms-wmv");
    public static final a L = b("application", "xml");
    public static final a M = b("application", "atom+xml");
    public static final a N = a("application", "x-bzip2");
    public static final a O = b("application", "dart");
    public static final a P = a("application", "vnd.apple.pkpass");
    public static final a Q = a("application", "vnd.ms-fontobject");
    public static final a R = a("application", "epub+zip");
    public static final a S = a("application", "x-www-form-urlencoded");
    public static final a T = a("application", "pkcs12");
    public static final a U = a("application", "binary");
    public static final a V = a("application", "x-gzip");
    public static final a W = b("application", "javascript");
    public static final a X = b("application", "json");
    public static final a Y = b("application", "manifest+json");
    public static final a Z = a("application", "vnd.google-earth.kml+xml");
    public static final a a = a("*", "*");
    public static final a aA = b("application", "xrd+xml");
    public static final a aB = a("application", "zip");
    private static final ae<String, String> aC = ae.d("charset", com.google.a.a.a.a(c.c.name()));
    private static final b aD = b.c.a(b.j.o()).a(b.b(' ')).a(b.b((CharSequence) "()<>@,;:\\\"/[]?="));
    private static final b aE = b.c.a(b.b((CharSequence) "\"\\\r"));
    private static final b aF = b.a((CharSequence) " \t\r\n");
    private static final Map<a, a> aG = ay.c();
    private static final com.google.a.a.f.a aM = f.a("; ").c("=");
    public static final a aa = a("application", "vnd.google-earth.kmz");
    public static final a ab = a("application", "mbox");
    public static final a ac = a("application", "x-apple-aspen-config");
    public static final a ad = a("application", "vnd.ms-excel");
    public static final a ae = a("application", "vnd.ms-powerpoint");
    public static final a af = a("application", "msword");
    public static final a ag = a("application", "octet-stream");
    public static final a ah = a("application", "ogg");
    public static final a ai = a("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final a aj = a("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final a ak = a("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final a al = a("application", "vnd.oasis.opendocument.graphics");
    public static final a am = a("application", "vnd.oasis.opendocument.presentation");
    public static final a an = a("application", "vnd.oasis.opendocument.spreadsheet");
    public static final a ao = a("application", "vnd.oasis.opendocument.text");
    public static final a ap = a("application", "pdf");
    public static final a aq = a("application", "postscript");
    public static final a ar = a("application", "protobuf");
    public static final a as = b("application", "rdf+xml");
    public static final a at = b("application", "rtf");
    public static final a au = a("application", "font-sfnt");
    public static final a av = a("application", "x-shockwave-flash");
    public static final a aw = a("application", "vnd.sketchup.skp");
    public static final a ax = a("application", "x-tar");
    public static final a ay = a("application", "font-woff");
    public static final a az = b("application", "xhtml+xml");
    public static final a b = a("text", "*");
    public static final a c = a("image", "*");
    public static final a d = a("audio", "*");
    public static final a e = a("video", "*");
    public static final a f = a("application", "*");
    public static final a g = b("text", "cache-manifest");
    public static final a h = b("text", "css");
    public static final a i = b("text", "csv");
    public static final a j = b("text", "html");
    public static final a k = b("text", "calendar");
    public static final a l = b("text", "plain");
    public static final a m = b("text", "javascript");
    public static final a n = b("text", "tab-separated-values");
    public static final a o = b("text", "vcard");
    public static final a p = b("text", "vnd.wap.wml");
    public static final a q = b("text", "xml");
    public static final a r = a("image", "bmp");
    public static final a s = a("image", "x-canon-crw");
    public static final a t = a("image", "gif");
    public static final a u = a("image", "vnd.microsoft.icon");
    public static final a v = a("image", "jpeg");
    public static final a w = a("image", "png");
    public static final a x = a("image", "vnd.adobe.photoshop");
    public static final a y = b("image", "svg+xml");
    public static final a z = a("image", "tiff");
    private final String aH;
    private final String aI;
    private final ae<String, String> aJ;
    private String aK;
    private int aL;

    private static a a(String str, String str2) {
        return a(new a(str, str2, ae.a()));
    }

    private static a b(String str, String str2) {
        return a(new a(str, str2, aC));
    }

    private static a a(a aVar) {
        aG.put(aVar, aVar);
        return aVar;
    }

    private a(String str, String str2, ae<String, String> aeVar) {
        this.aH = str;
        this.aI = str2;
        this.aJ = aeVar;
    }

    private Map<String, al<String>> b() {
        return ay.a(this.aJ.o(), new e<Collection<String>, al<String>>(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public /* synthetic */ Object apply(Object obj) {
                return a((Collection) obj);
            }

            public al<String> a(Collection<String> collection) {
                return al.a((Iterable) collection);
            }
        });
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.aH.equals(aVar.aH) && this.aI.equals(aVar.aI) && b().equals(aVar.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.aL;
        if (i != 0) {
            return i;
        }
        i = g.a(this.aH, this.aI, b());
        this.aL = i;
        return i;
    }

    public String toString() {
        String str = this.aK;
        if (str != null) {
            return str;
        }
        str = c();
        this.aK = str;
        return str;
    }

    private String c() {
        StringBuilder append = new StringBuilder().append(this.aH).append('/').append(this.aI);
        if (!this.aJ.j()) {
            append.append("; ");
            aM.a(append, bb.a(this.aJ, new e<String, String>(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public /* synthetic */ Object apply(Object obj) {
                    return a((String) obj);
                }

                public String a(String str) {
                    return a.aD.c((CharSequence) str) ? str : a.b(str);
                }
            }).g());
        }
        return append.toString();
    }

    private static String b(String str) {
        StringBuilder append = new StringBuilder(str.length() + 16).append('\"');
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\r' || charAt == '\\' || charAt == '\"') {
                append.append('\\');
            }
            append.append(charAt);
        }
        return append.append('\"').toString();
    }
}
