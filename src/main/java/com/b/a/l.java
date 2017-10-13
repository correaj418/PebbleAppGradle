package com.b.a;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.spi.AbstractSelectableChannel;

abstract class l implements ReadableByteChannel, ScatteringByteChannel {
    private AbstractSelectableChannel a;

    public abstract int a(ByteBuffer[] byteBufferArr);

    public abstract void a();

    public abstract boolean b();

    l(AbstractSelectableChannel abstractSelectableChannel) {
        abstractSelectableChannel.configureBlocking(false);
        this.a = abstractSelectableChannel;
    }

    public boolean c() {
        return false;
    }

    public boolean isOpen() {
        return this.a.isOpen();
    }

    public void close() {
        this.a.close();
    }
}
