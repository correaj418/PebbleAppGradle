package com.getpebble.android.framework.p;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.ae;
import com.getpebble.android.h.h;
import java.net.URL;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class g {
    private final int a;
    private final String b;
    private final UUID c;
    private final boolean d;
    private final URL e;
    private final c f;
    private final b g;
    private final String h;
    private final String i;

    private static class a {
        @com.google.b.a.c(a = "dictation_type")
        private final String a = "Dictation";
        @com.google.b.a.c(a = "dictation_language")
        private final String b = g.j();
        @com.google.b.a.c(a = "locale")
        private final String c = g.j();
        @com.google.b.a.c(a = "application_name")
        private final String d;
        @com.google.b.a.c(a = "organization_id")
        private final String e = "Pebble Technology";
        @com.google.b.a.c(a = "phone_OS")
        private final String f = VERSION.RELEASE;
        @com.google.b.a.c(a = "phone_network")
        private final String g = g.n();
        @com.google.b.a.c(a = "audio_source")
        private final String h = "SpeakerAndMicrophone";
        @com.google.b.a.c(a = "location")
        private final String i = null;
        @com.google.b.a.c(a = "application_session_id")
        private final String j = UUID.randomUUID().toString();
        @com.google.b.a.c(a = "utterance_number")
        private final String k = "0";
        @com.google.b.a.c(a = "ui_language")
        private final String l = g.j();
        @com.google.b.a.c(a = "phone_submodel")
        private final String m = null;
        @com.google.b.a.c(a = "application_state_id")
        private final String n = null;

        public a(String str) {
            this.d = str;
        }

        public String toString() {
            return "CommandDictionary{dictationType='Dictation', dictationLanguage='" + this.b + '\'' + ", locale='" + this.c + '\'' + ", applicationName='" + this.d + '\'' + ", organizationId='" + "Pebble Technology" + '\'' + ", phoneOS='" + this.f + '\'' + ", phoneNetwork='" + this.g + '\'' + ", audioSource='" + "SpeakerAndMicrophone" + '\'' + ", location='" + this.i + '\'' + ", appSessionId='" + this.j + '\'' + ", utteranceNumber='" + "0" + '\'' + ", uiLanguage='" + this.l + '\'' + ", phoneSubmodel='" + this.m + '\'' + ", appStateId='" + this.n + '\'' + '}';
        }
    }

    public static class b {
        @com.google.b.a.c(a = "appKey")
        private final String a;
        @com.google.b.a.c(a = "appId")
        private final String b;
        @com.google.b.a.c(a = "uId")
        private final String c;
        @com.google.b.a.c(a = "inCodec")
        private final String d;
        @com.google.b.a.c(a = "outCodec")
        private final String e;
        @com.google.b.a.c(a = "cmdName")
        private final String f = "NMDP_ASR_CMD";
        @com.google.b.a.c(a = "appName")
        private final String g = "com.getpebble.android.basalt";
        @com.google.b.a.c(a = "appVersion")
        private final String h = ("4.4.1-1404-01abd2f76-endframe_" + String.valueOf(1404));
        @com.google.b.a.c(a = "language")
        private String i = g.j();
        @com.google.b.a.c(a = "cmdTimeout")
        private final long j = TimeUnit.SECONDS.toMillis(45);
        @com.google.b.a.c(a = "carrier")
        private final String k = g.q();
        @com.google.b.a.c(a = "deviceModel")
        private final String l = Build.MODEL;
        @com.google.b.a.c(a = "cmdDict")
        private final a m;

        b(int i, a aVar, boolean z, h hVar) {
            this.d = a(i);
            this.e = this.d;
            this.b = z ? hVar.a() : hVar.b();
            this.a = z ? hVar.c() : hVar.d();
            this.c = ae.a();
            this.m = aVar;
        }

        static String a(int i) {
            return String.format(Locale.US, "SPEEX_%dK", new Object[]{Integer.valueOf(i / 1000)});
        }

        public String toString() {
            return "RequestData{, userId='" + this.c + '\'' + ", inCodec='" + this.d + '\'' + ", outCodec='" + this.e + '\'' + ", cmdName='" + "NMDP_ASR_CMD" + '\'' + ", appName='" + "com.getpebble.android.basalt" + '\'' + ", appVersion='" + this.h + '\'' + ", language='" + this.i + '\'' + ", timeoutMs=" + this.j + ", carrier='" + this.k + '\'' + ", deviceModel='" + this.l + '\'' + ", commandDictionary=" + this.m + '}';
        }
    }

    public static class c {
        @com.google.b.a.c(a = "start")
        private final int a = 0;
        @com.google.b.a.c(a = "end")
        private final int b = 0;
        @com.google.b.a.c(a = "text")
        private final String c = "";
        @com.google.b.a.c(a = "nlsml_results")
        private final int d = 0;
        @com.google.b.a.c(a = "enable_intermediate_response")
        private final int e = 0;

        public String toString() {
            return "RequestInfo{start=0, end=0, text='', results=0, enableIntermediateResponse=0}";
        }
    }

    private g(int i, String str, UUID uuid, boolean z, URL url, c cVar, b bVar, String str2, String str3) {
        this.a = i;
        this.e = url;
        this.b = str;
        this.c = uuid;
        this.d = z;
        this.f = cVar;
        this.g = bVar;
        this.h = str2;
        this.i = str3;
    }

    public c a() {
        return this.f;
    }

    public b b() {
        return this.g;
    }

    public URL c() {
        return this.e;
    }

    public int d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public UUID f() {
        return this.c;
    }

    public boolean g() {
        return this.d;
    }

    public String h() {
        return this.h;
    }

    public static g a(int i, String str, UUID uuid, boolean z, String str2, String str3) {
        return new g(i, str, uuid, z, m(), new c(), new b(i, new a(z ? "com.getpebble.android.basalt" : str3 + "_" + str), z, new h()), str2, str3);
    }

    private static URL m() {
        try {
            return new URL("https", i(), 443, "/NmspServlet/");
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    static String i() {
        String j = j();
        i iVar = new i();
        Object a = iVar.a(j);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        f.a("NuanceConfig", "Unable to determine URL for locale: " + j);
        if (!o().equals(j())) {
            String o = o();
            f.b("NuanceConfig", "Falling back to default locale: " + o);
            o = iVar.a(o);
            if (!TextUtils.isEmpty(o)) {
                return o;
            }
        }
        f.a("NuanceConfig", "Falling back to default, hard-coded endpoint: pebble-ncs-eng-USA.nuancemobility.net");
        return "pebble-ncs-eng-USA.nuancemobility.net";
    }

    public String toString() {
        return "NuanceConfig{rate=" + this.a + ", applicationName='" + this.b + '\'' + ", applicationUUID=" + this.c + ", isFirstParty=" + this.d + ", url=" + this.e + ", requestInfo=" + this.f + ", requestData=" + this.g + ", serialNumber='" + this.h + '\'' + ", developerId='" + this.i + '\'' + '}';
    }

    private static String n() {
        return h.c(p());
    }

    static String j() {
        return PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.VOICE_LANGUAGE, o());
    }

    private static String o() {
        return p().getString(R.string.onboarding_default_language_code);
    }

    private static Context p() {
        return com.getpebble.android.common.a.K();
    }

    private static String q() {
        return com.getpebble.android.framework.o.c.b(p());
    }
}
