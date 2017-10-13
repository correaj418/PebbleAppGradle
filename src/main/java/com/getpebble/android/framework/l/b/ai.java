package com.getpebble.android.framework.l.b;

import c.b.a.b;
import c.b.a.f;
import com.getpebble.android.h.ab;
import com.google.a.f.d;
import com.google.a.f.e;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class ai extends r {

    public enum a {
        UNKNOWN((byte) -1),
        GET_TIME_REQ((byte) 0),
        GET_TIME_RESP((byte) 1),
        SET_LOCAL_TIME_REQ((byte) 2),
        SET_UTC_TIME_ZONE_REQ((byte) 3);
        
        private byte command;

        private a(byte b) {
            this.command = b;
        }

        public byte getCommand() {
            return this.command;
        }

        public static a fromByte(byte b) {
            for (a aVar : values()) {
                if (aVar.command == b) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }
    }

    public ai() {
        super(com.getpebble.android.bluetooth.g.a.TIME);
    }

    protected e b() {
        return e.a((long) ab.a());
    }

    protected short h() {
        TimeZone timeZone = TimeZone.getDefault();
        if ("Europe/Kaliningrad".equalsIgnoreCase(timeZone.getID())) {
            return j();
        }
        return (short) ((int) TimeUnit.MILLISECONDS.toMinutes((long) timeZone.getOffset(System.currentTimeMillis())));
    }

    private short j() {
        return (short) ((int) TimeUnit.MILLISECONDS.toMinutes((long) f.a().b(b.a().c())));
    }

    protected String i() {
        return TimeZone.getDefault().getID();
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(a.SET_UTC_TIME_ZONE_REQ.getCommand()));
            e b = b();
            short h = h();
            a(com.getpebble.android.bluetooth.b.b.a(b));
            a(com.getpebble.android.bluetooth.b.b.a(h));
            CharSequence i = i();
            byte[] b2 = com.getpebble.android.bluetooth.b.b.b(i, 32);
            com.getpebble.android.common.b.a.f.d("PebbleSetTimeMessage", "Sending timezone: '" + i + "' utc = " + b + " offset mins = " + h);
            a(Byte.valueOf(d.a((long) b2.length)));
            a(b2);
        }
        return super.c_();
    }
}
