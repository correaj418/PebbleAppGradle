package com.getpebble.android.bluetooth.j;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.content.Context;
import android.os.Build.VERSION;
import com.getpebble.android.common.b.a.f;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class b {
    private static final UUID a = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private final BluetoothDevice b;
    private final a c;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public b(BluetoothDevice bluetoothDevice, a aVar) {
        if (bluetoothDevice == null) {
            throw new IllegalArgumentException("error: the bluetoothDevice is null");
        }
        this.b = bluetoothDevice;
        this.c = aVar;
    }

    public String a() {
        return this.b.getAddress();
    }

    public String b() {
        return this.b.getName();
    }

    public BluetoothClass c() {
        return this.b.getBluetoothClass();
    }

    public BluetoothDevice d() {
        return this.b;
    }

    public static int a(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.getType();
    }

    public int e() {
        return a(this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (a() != null) {
            if (a().equals(bVar.a())) {
                return true;
            }
        } else if (bVar.a() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return a() != null ? a().hashCode() : 0;
    }

    public boolean f() {
        boolean createBond;
        Throwable e;
        Throwable th;
        if (h()) {
            f.d("PebbleBluetoothDevice", "createBond(): already bonded");
            return false;
        } else if (VERSION.SDK_INT >= 19) {
            f.d("PebbleBluetoothDevice", "createBond()");
            if (this.b == null) {
                throw new a("mBluetoothDevice is null");
            }
            createBond = this.b.createBond();
            if (createBond) {
                return createBond;
            }
            throw new a("!ret for createBond()");
        } else {
            f.d("PebbleBluetoothDevice", "createBondLegacy()");
            try {
                createBond = ((Boolean) this.b.getClass().getMethod("createBond", (Class[]) null).invoke(this.b, (Object[]) null)).booleanValue();
                try {
                    f.d("PebbleBluetoothDevice", "legacy createBond reflection res = " + createBond);
                    if (createBond) {
                        return createBond;
                    }
                    throw new a("!ret for createBond() (legacy)");
                } catch (NoSuchMethodException e2) {
                    e = e2;
                    f.a("PebbleBluetoothDevice", "Error creating legacy bond", e);
                    return createBond;
                } catch (InvocationTargetException e3) {
                    e = e3;
                    f.a("PebbleBluetoothDevice", "Error creating legacy bond", e);
                    return createBond;
                } catch (IllegalAccessException e4) {
                    e = e4;
                    f.a("PebbleBluetoothDevice", "Error creating legacy bond", e);
                    return createBond;
                }
            } catch (Throwable e5) {
                th = e5;
                createBond = false;
                e = th;
                f.a("PebbleBluetoothDevice", "Error creating legacy bond", e);
                return createBond;
            } catch (Throwable e52) {
                th = e52;
                createBond = false;
                e = th;
                f.a("PebbleBluetoothDevice", "Error creating legacy bond", e);
                return createBond;
            } catch (Throwable e522) {
                th = e522;
                createBond = false;
                e = th;
                f.a("PebbleBluetoothDevice", "Error creating legacy bond", e);
                return createBond;
            }
        }
    }

    public c g() {
        f.d("PebbleBluetoothDevice", "createSocket()");
        return new c(this.b.createRfcommSocketToServiceRecord(a), this.b);
    }

    public boolean h() {
        if (this.b.getBondState() == 12) {
            return true;
        }
        if (!this.c.e().contains(this)) {
            return false;
        }
        f.d("PebbleBluetoothDevice", "getBondState returned not bonded, but in bonded devices list...");
        return true;
    }

    public void i() {
        try {
            f.d("PebbleBluetoothDevice", "setPairingConfirmation() = " + ((Boolean) this.b.getClass().getMethod("setPairingConfirmation", new Class[]{Boolean.TYPE}).invoke(this.b, new Object[]{Boolean.valueOf(true)})).booleanValue());
        } catch (Throwable e) {
            f.b("PebbleBluetoothDevice", "acceptPairingRequest() error for " + this.b.getAddress(), e);
        }
    }

    public boolean j() {
        try {
            return ((Boolean) this.b.getClass().getMethod("removeBond", (Class[]) null).invoke(this.b, new Object[0])).booleanValue();
        } catch (Throwable e) {
            f.b("PebbleBluetoothDevice", "Error calling removeBond() for " + this.b.getAddress(), e);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public BluetoothGatt a(BluetoothGattCallback bluetoothGattCallback, Context context) {
        return this.b.connectGatt(context, false, bluetoothGattCallback);
    }

    public String a(int i) {
        return a() + " / " + b() + " type = " + e() + " class = " + c() + " bondState = " + this.b.getBondState() + " connectionState = " + d(i);
    }

    private static String d(int i) {
        String str;
        if (i == -1) {
            str = "Unknown";
        } else if (i == 0) {
            str = "Disconnected";
        } else if ((i & 2) > 0) {
            str = "Connected / BREDR";
        } else if ((i & 4) > 0) {
            str = "Connected / Encrypted LE";
        } else {
            str = "Connected";
        }
        return str + " (" + i + ")";
    }

    public int k() {
        Object h = this.c.h();
        if (h == null) {
            return -1;
        }
        try {
            return ((Integer) h.getClass().getMethod("getConnectionState", new Class[]{BluetoothDevice.class}).invoke(h, new Object[]{this.b})).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public static Boolean b(int i) {
        if (i == -1) {
            return null;
        }
        return Boolean.valueOf(i > 0);
    }

    public static boolean c(int i) {
        Boolean b = b(i);
        return b != null && b.booleanValue();
    }
}
