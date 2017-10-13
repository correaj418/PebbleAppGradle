package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.google.a.f.e;
import java.util.Iterator;
import java.util.List;

public class m extends r {
    private a a;
    private List<e> e;
    private e f;

    public enum a {
        REPORT_OPEN_SESSIONS((byte) -124),
        ACK((byte) -123),
        NACK((byte) -122),
        UNKNOWN((byte) -1);
        
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

    private m(a aVar) {
        super(com.getpebble.android.bluetooth.g.a.DATA_LOG);
        this.a = aVar;
    }

    public static m a(List<e> list) {
        m mVar = new m(a.REPORT_OPEN_SESSIONS);
        mVar.e = list;
        return mVar;
    }

    public static m a(e eVar) {
        m mVar = new m(a.ACK);
        mVar.f = eVar;
        return mVar;
    }

    public static m b(e eVar) {
        m mVar = new m(a.NACK);
        mVar.f = eVar;
        return mVar;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf(this.a.getCommand()));
            switch (this.a) {
                case REPORT_OPEN_SESSIONS:
                    Iterator it = this.e.iterator();
                    while (it.hasNext()) {
                        a(Byte.valueOf(b.b((e) it.next())));
                    }
                    break;
                case ACK:
                case NACK:
                    a(Byte.valueOf(b.b(this.f)));
                    break;
            }
        }
        return super.c_();
    }
}
