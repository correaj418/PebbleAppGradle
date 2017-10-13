package com.getpebble.android.bluetooth.e;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.b;
import com.getpebble.android.common.b.a.f;

@SuppressLint({"NewApi"})
public class n extends BluetoothGattCallback {
    private a a;
    private final PebbleDevice b;

    interface a {
        void a(BluetoothGattCharacteristic bluetoothGattCharacteristic);

        void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, d dVar);

        void a(BluetoothGattDescriptor bluetoothGattDescriptor);

        void a(c cVar, d dVar, int i);

        void b(int i);

        void b(BluetoothGattCharacteristic bluetoothGattCharacteristic);

        void i();
    }

    n(a aVar, PebbleDevice pebbleDevice) {
        this.a = aVar;
        this.b = pebbleDevice;
    }

    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (bluetoothGatt.getDevice().getAddress().equals(this.b.getAddress())) {
            d fromCode = d.fromCode(i);
            if (fromCode.isError()) {
                f.b("PebbleBluetoothGattCallback", "onDescriptorRead() status = " + fromCode);
            }
        }
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (bluetoothGatt.getDevice().getAddress().equals(this.b.getAddress())) {
            d fromCode = d.fromCode(i);
            c fromCode2 = c.fromCode(i2);
            f.d("PebbleBluetoothGattCallback", "onConnectionStateChange() status = " + fromCode + " (" + i + ") newState = " + fromCode2);
            this.a.a(fromCode2, fromCode, i);
            return;
        }
        f.b("PebbleBluetoothGattCallback", "onConnectionStateChange() for wrong device: " + bluetoothGatt.getDevice().getAddress() + " / expecting: " + this.b.getAddress());
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        if (bluetoothGatt.getDevice().getAddress().equals(this.b.getAddress())) {
            f.d("PebbleBluetoothGattCallback", "onServicesDiscovered() status = " + d.fromCode(i));
            this.a.i();
            return;
        }
        f.b("PebbleBluetoothGattCallback", "onServicesDiscovered for wrong device: " + bluetoothGatt.getDevice().getAddress() + " / expecting: " + this.b.getAddress());
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (bluetoothGatt.getDevice().getAddress().equals(this.b.getAddress())) {
            d fromCode = d.fromCode(i);
            f.d("PebbleBluetoothGattCallback", "onCharacteristicRead() status = " + fromCode);
            this.a.a(bluetoothGattCharacteristic, fromCode);
            return;
        }
        f.b("PebbleBluetoothGattCallback", "onCharacteristicRead for wrong device: " + bluetoothGatt.getDevice().getAddress() + " / expecting: " + this.b.getAddress());
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (bluetoothGatt.getDevice().getAddress().equals(this.b.getAddress())) {
            b.a("PebbleBluetoothGattCallback", "onCharacteristicWrite() status = " + d.fromCode(i));
            this.a.b(bluetoothGattCharacteristic);
            return;
        }
        f.b("PebbleBluetoothGattCallback", "onCharacteristicWrite for wrong device: " + bluetoothGatt.getDevice().getAddress() + " / expecting: " + this.b.getAddress());
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGatt.getDevice().getAddress().equals(this.b.getAddress())) {
            this.a.a(bluetoothGattCharacteristic);
        } else {
            f.b("PebbleBluetoothGattCallback", "onCharacteristicChanged for wrong device: " + bluetoothGatt.getDevice().getAddress() + " / expecting: " + this.b.getAddress());
        }
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (bluetoothGatt.getDevice().getAddress().equals(this.b.getAddress())) {
            d fromCode = d.fromCode(i);
            if (fromCode.isError()) {
                f.b("PebbleBluetoothGattCallback", "onDescriptorWrite() status = " + fromCode);
            }
            this.a.a(bluetoothGattDescriptor);
            return;
        }
        f.b("PebbleBluetoothGattCallback", "onDescriptorWrite for wrong device: " + bluetoothGatt.getDevice().getAddress() + " / expecting: " + this.b.getAddress());
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (bluetoothGatt.getDevice().getAddress().equals(this.b.getAddress())) {
            d fromCode = d.fromCode(i2);
            if (fromCode.isError()) {
                f.b("PebbleBluetoothGattCallback", "onMtuChanged status = " + fromCode);
            }
            this.a.b(i);
            return;
        }
        f.b("PebbleBluetoothGattCallback", "onMtuChanged for wrong device: " + bluetoothGatt.getDevice().getAddress() + " / expecting: " + this.b.getAddress());
    }

    void a(a aVar) {
        this.a = aVar;
    }
}
