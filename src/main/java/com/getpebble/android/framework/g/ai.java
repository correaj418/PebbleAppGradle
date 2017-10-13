package com.getpebble.android.framework.g;

import android.os.Handler;
import com.getpebble.android.bluetooth.g.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.g.ak.c;
import com.getpebble.android.framework.l.a.g;
import com.getpebble.android.framework.l.a.h;
import com.getpebble.android.framework.l.a.y;
import com.getpebble.android.framework.l.b.ah;
import com.getpebble.android.framework.p.n;
import com.getpebble.android.framework.p.n.b;
import com.getpebble.android.framework.p.o;
import com.google.a.b.am;
import java.util.Set;

public class ai extends ac implements b {
    private final p a;
    private final o b;
    private final Handler c;
    private n d;

    public ai(p pVar, Handler handler, o oVar) {
        this.a = pVar;
        this.c = handler;
        this.b = oVar;
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        return false;
    }

    Set<a> a() {
        return am.a(a.VOICE_CONTROL, a.AUDIO_STREAMING);
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        switch (a.fromCode(bVar.a())) {
            case VOICE_CONTROL:
                b(bVar);
                return true;
            case AUDIO_STREAMING:
                c(bVar);
                return true;
            default:
                return false;
        }
    }

    private void b(final com.getpebble.android.bluetooth.g.b bVar) {
        this.c.post(new Runnable(this) {
            final /* synthetic */ ai b;

            public void run() {
                if (this.b.d() != null) {
                    this.b.d().e();
                }
                f.d("VoiceControlEndpoint", "handleVoiceControlMessage()");
                try {
                    y yVar = new y(bVar);
                    f.d("VoiceControlEndpoint", "handleVoiceControlMessage: Starting audio streaming... Encoded with Speex " + yVar.d().a);
                    this.b.d = this.b.b.a(yVar, this.b, this.b.c);
                    this.b.d().a(yVar.d().b);
                } catch (Throwable e) {
                    f.a("VoiceControlEndpoint", "handleVoiceControlMessage: Error parsing message", e);
                    this.b.a.a(new ah(y.b.DICTATION, c.ERROR_UNSUPPORTED_CONFIGURATION, aj.FIRST_PARTY));
                }
            }
        });
    }

    private void c(final com.getpebble.android.bluetooth.g.b bVar) {
        if (d() != null) {
            final short d = d().d();
            this.c.post(new Runnable(this) {
                final /* synthetic */ ai c;

                public void run() {
                    h.a from = h.a.from(bVar.b().get());
                    n d = this.c.d();
                    if (d == null) {
                        f.b("VoiceControlEndpoint", "Received an audio streaming message of type" + from + " while handling session " + d + ", but by the time the Handler picked up our Runnable we are no longer in a session");
                    } else if (d.d() != d) {
                        f.b("VoiceControlEndpoint", "Received an audio streaming message of type" + from + " while handling session " + d + ", but by the time the Handler picked up our Runnable we are now processing session " + d.d());
                    } else {
                        switch (from) {
                            case DATA_PACKET:
                                try {
                                    g gVar = new g(bVar);
                                    if (gVar.d() != d) {
                                        f.b("VoiceControlEndpoint", "Received an audio streaming message of type" + from + " for session " + gVar.d() + ", but at the time we received it we were already processing session " + d);
                                        return;
                                    } else {
                                        d.a(gVar);
                                        return;
                                    }
                                } catch (Throwable e) {
                                    f.a("VoiceControlEndpoint", "handleAudioStreamingMessage: Unable to parse message", e);
                                    d.e();
                                    return;
                                }
                            case STOP_PACKET:
                                d.f();
                                return;
                            default:
                                f.a("VoiceControlEndpoint", "handleAudioStreamingMessage: Received unknown packet id: " + from);
                                return;
                        }
                    }
                }
            });
        }
    }

    public void a(c cVar) {
    }

    public void c() {
        this.d = null;
    }

    void b() {
    }

    n d() {
        return this.d;
    }
}
