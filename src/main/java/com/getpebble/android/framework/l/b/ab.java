package com.getpebble.android.framework.l.b;

public class ab extends r {
    private final b a;
    private final byte[] e;
    private final c f;
    private final a g;

    public enum a {
        READ(0),
        WRITE(2),
        REMOVE(4);
        
        private final int id;

        private a(int i) {
            this.id = i;
        }

        public int getId() {
            return this.id;
        }
    }

    public enum b {
        PCB_TEST_DATE("mfg_pcbtestdate"),
        RTC_FREQ("mfg_rtcfreq"),
        TEST_RESULT("mfg_testresult"),
        MISC("mfg_misc"),
        FUNC_TEST("mfg_functest"),
        COLOR("mfg_color"),
        FAC_MODE("mfg_facmode");
        
        private final String mKeyCode;

        public String getString() {
            return this.mKeyCode;
        }

        private b(String str) {
            this.mKeyCode = str;
        }
    }

    public enum c {
        SYSTEM(com.getpebble.android.bluetooth.g.a.SYS_REG),
        FACTORY(com.getpebble.android.bluetooth.g.a.FCT_REG);
        
        private final com.getpebble.android.bluetooth.g.a mEndpointId;

        private c(com.getpebble.android.bluetooth.g.a aVar) {
            this.mEndpointId = aVar;
        }

        public com.getpebble.android.bluetooth.g.a getEndpointId() {
            return this.mEndpointId;
        }
    }

    public ab(b bVar, int i, c cVar, a aVar) {
        super(cVar.getEndpointId());
        this.a = bVar;
        this.e = com.getpebble.android.bluetooth.b.b.b(i);
        this.f = cVar;
        this.g = aVar;
    }

    public synchronized byte[] c_() {
        if (!d()) {
            a(Byte.valueOf((byte) this.g.getId()));
            a(Byte.valueOf((byte) (this.a.getString().length() & 255)));
            if (this.g == a.WRITE) {
                a(Byte.valueOf((byte) (this.e.length & 255)));
            }
            com.getpebble.android.bluetooth.b.b.a((com.getpebble.android.bluetooth.b.b.a) this, this.a.getString(), this.a.getString().length());
            if (this.g == a.WRITE) {
                a(this.e);
            }
        }
        return super.c_();
    }
}
