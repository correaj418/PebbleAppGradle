package com.getpebble.android.common.model.a;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.model.a.p.a;
import com.getpebble.android.common.model.u;
import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class y extends q {
    @c(a = "data")
    public final Integer[] a;

    public y(u uVar, Integer[] numArr) {
        super(a(uVar));
        this.a = numArr;
    }

    public static p a(u uVar) {
        return p.from(uVar.blobDbKeyName, a.TYPICAL_STEPS);
    }

    public byte[] toBytes() {
        ByteBuffer allocate = ByteBuffer.allocate(this.a.length * 2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        for (Integer num : this.a) {
            allocate.put(b.a(num == null ? 0 : num.intValue()));
        }
        return allocate.array();
    }

    public int[] a() {
        int[] iArr = new int[this.a.length];
        for (int i = 0; i < this.a.length; i++) {
            iArr[i] = this.a[i] == null ? 0 : this.a[i].intValue();
        }
        return iArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        return Arrays.deepEquals(this.a, ((y) obj).a);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(this.a);
    }
}
