package com.getpebble.android.bluetooth.e;

public enum d {
    GATT_SUCCESS(0),
    GATT_READ_NOT_PERMITTED(2),
    GATT_WRITE_NOT_PERMITTED(3),
    GATT_INSUFFICIENT_AUTHENTICATION(5),
    GATT_REQUEST_NOT_SUPPORTED(6),
    GATT_INSUFFICIENT_ENCRYPTION(15),
    GATT_INVALID_OFFSET(7),
    GATT_INVALID_ATTRIBUTE_LENGTH(13),
    GATT_CONNECTION_CONGESTED(143),
    GATT_FAILURE(257),
    GATT_ERROR(133),
    GATT_UNKNOWN_CONNECTION_ERROR_8(8),
    GATT_UNKNOWN_0X16(22),
    UNKNOWN(-1);
    
    public final int mCode;

    private d(int i) {
        this.mCode = i;
    }

    public static d fromCode(int i) {
        for (d dVar : values()) {
            if (dVar.mCode == i) {
                return dVar;
            }
        }
        return UNKNOWN;
    }

    public String toString() {
        return name() + " (" + this.mCode + ")";
    }

    public boolean isError() {
        return !equals(GATT_SUCCESS);
    }
}
