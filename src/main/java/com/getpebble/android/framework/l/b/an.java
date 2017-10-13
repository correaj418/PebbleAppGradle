package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.model.bc.a;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record;
import com.google.a.f.d;
import com.google.a.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

public class an {
    private final byte[] a;

    public an(a aVar, Record record) {
        ByteBuffer allocate = ByteBuffer.allocate(r.a(com.getpebble.android.bluetooth.g.a.BLOBDB_V1));
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(d.a(3));
        allocate.putShort(aVar.d.shortValue());
        allocate.put(d.a((long) aVar.e.value()));
        allocate.putShort(aVar.f.shortValue());
        allocate.putShort(aVar.g.shortValue());
        allocate.put(d.a((long) aVar.h.value()));
        allocate.putShort(aVar.i.shortValue());
        allocate.putShort(aVar.j.shortValue());
        allocate.put(b.c(e.a(aVar.l / 1000)));
        allocate.put((byte) (record.isDynamic ? 1 : 0));
        byte[] a = a(WeatherChannelDataModels.getLocationName(record, record.latitude, record.longitude), aVar);
        allocate.put(b.b(e.a((long) a.length), ByteOrder.LITTLE_ENDIAN));
        allocate.put(a);
        this.a = new byte[allocate.position()];
        allocate.position(0);
        allocate.get(this.a);
    }

    public byte[] a() {
        return this.a;
    }

    public static byte[] a(String str, a aVar) {
        ByteBuffer allocate = ByteBuffer.allocate(r.a(com.getpebble.android.bluetooth.g.a.BLOBDB_V1));
        allocate.put(b.a(str.toUpperCase(Locale.getDefault()), 64, ByteOrder.LITTLE_ENDIAN));
        allocate.put(b.a(aVar.k, 32, ByteOrder.LITTLE_ENDIAN));
        byte[] bArr = new byte[allocate.position()];
        allocate.position(0);
        allocate.get(bArr);
        return bArr;
    }
}
