package com.b.b.h;

import java.util.HashMap;
import java.util.Locale;

public class g {
    private static final HashMap<String, a> a = new HashMap();
    private static final HashMap<String, Integer> b = new HashMap();
    private static final HashMap<String, Integer> c = new HashMap();
    private static final HashMap<String, Integer> d = new HashMap();
    private static final HashMap<Integer, String> e = new HashMap();
    private static final HashMap<String, String> f = new HashMap();

    public static class a {
        public final int a;
        public final String b;

        a(int i, String str) {
            this.a = i;
            this.b = str;
        }
    }

    static {
        a("MP3", 1, "audio/mpeg", 12297);
        a("MPGA", 1, "audio/mpeg", 12297);
        a("M4A", 2, "audio/mp4", 12299);
        a("WAV", 3, "audio/x-wav", 12296);
        a("WAV", 15, "audio/wav");
        a("AMR", 4, "audio/amr");
        a("AWB", 5, "audio/amr-wb");
        a("DIVX", 31, "video/divx");
        a("QCP", 13, "audio/qcelp");
        a("OGG", 7, "audio/ogg", 47362);
        a("OGG", 7, "application/ogg", 47362);
        a("OGA", 7, "audio/ogg", 47362);
        a("OGA", 7, "application/ogg", 47362);
        a("AAC", 8, "audio/aac", 47363);
        a("AAC", 8, "audio/aac-adts", 47363);
        a("MKA", 9, "audio/x-matroska");
        a("MID", 17, "audio/midi");
        a("MIDI", 17, "audio/midi");
        a("XMF", 17, "audio/midi");
        a("RTTTL", 17, "audio/midi");
        a("SMF", 18, "audio/sp-midi");
        a("IMY", 19, "audio/imelody");
        a("RTX", 17, "audio/midi");
        a("OTA", 17, "audio/midi");
        a("MXMF", 17, "audio/midi");
        a("MPEG", 21, "video/mpeg", 12299);
        a("MPG", 21, "video/mpeg", 12299);
        a("MP4", 21, "video/mp4", 12299);
        a("MPEG4", 21, "video/mpeg4", 12299);
        a("M4V", 22, "video/m4v", 12299);
        a("3GP", 23, "video/3gpp", 47492);
        a("3GPP", 23, "video/3gpp", 47492);
        a("3G2", 24, "video/3gpp2", 47492);
        a("3GPP2", 24, "video/3gpp2", 47492);
        a("MKV", 27, "video/x-matroska");
        a("WEBM", 30, "video/webm");
        a("TS", 28, "video/mp2ts");
        a("MPG", 28, "video/mp2ts");
        a("AVI", 29, "video/avi");
        a("JPG", 32, "image/jpeg", 14337);
        a("JPEG", 32, "image/jpeg", 14337);
        a("GIF", 33, "image/gif", 14343);
        a("PNG", 34, "image/png", 14347);
        a("BMP", 35, "image/x-ms-bmp", 14340);
        a("WBMP", 36, "image/vnd.wap.wbmp");
        a("WEBP", 37, "image/webp");
        a("M3U", 41, "audio/x-mpegurl", 47633);
        a("M3U", 41, "application/x-mpegurl", 47633);
        a("PLS", 42, "audio/x-scpls", 47636);
        a("WPL", 43, "application/vnd.ms-wpl", 47632);
        a("M3U8", 44, "application/vnd.apple.mpegurl");
        a("M3U8", 44, "audio/mpegurl");
        a("M3U8", 44, "audio/x-mpegurl");
        a("FL", 51, "application/x-android-drm-fl");
        a("TXT", 100, "text/plain", 12292);
        a("HTM", 101, "text/html", 12293);
        a("HTML", 101, "text/html", 12293);
        a("PDF", 102, "application/pdf");
        a("DOC", 104, "application/msword", 47747);
        a("XLS", 105, "application/vnd.ms-excel", 47749);
        a("PPT", 106, "application/mspowerpoint", 47750);
        a("FLAC", 10, "audio/flac", 47366);
        a("ZIP", 107, "application/zip");
        a("MPG", 200, "video/mp2p");
        a("MPEG", 200, "video/mp2p");
    }

    static void a(String str, int i, String str2) {
        a.put(str, new a(i, str2));
        b.put(str2, Integer.valueOf(i));
    }

    static void a(String str, int i, String str2, int i2) {
        a(str, i, str2);
        c.put(str, Integer.valueOf(i2));
        d.put(str2, Integer.valueOf(i2));
        e.put(Integer.valueOf(i2), str2);
        f.put(str2, str);
    }

    public static boolean a(int i) {
        return (i >= 21 && i <= 31) || (i >= 200 && i <= 200);
    }

    public static a a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        return (a) a.get(str.substring(lastIndexOf + 1).toUpperCase(Locale.ROOT));
    }
}
