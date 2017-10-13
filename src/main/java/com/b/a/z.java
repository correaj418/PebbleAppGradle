package com.b.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

class z extends l {
    static final /* synthetic */ boolean b = (!z.class.desiredAssertionStatus());
    ServerSocketChannel a;

    public void a() {
    }

    z(ServerSocketChannel serverSocketChannel) {
        super(serverSocketChannel);
        this.a = serverSocketChannel;
    }

    public int read(ByteBuffer byteBuffer) {
        String str = "Can't read ServerSocketChannel";
        if (b) {
            throw new IOException("Can't read ServerSocketChannel");
        }
        throw new AssertionError();
    }

    public boolean b() {
        if (b) {
            return false;
        }
        throw new AssertionError();
    }

    public SelectionKey a(Selector selector) {
        return this.a.register(selector, 16);
    }

    public int a(ByteBuffer[] byteBufferArr) {
        String str = "Can't write ServerSocketChannel";
        if (b) {
            throw new IOException("Can't write ServerSocketChannel");
        }
        throw new AssertionError();
    }

    public long read(ByteBuffer[] byteBufferArr) {
        String str = "Can't read ServerSocketChannel";
        if (b) {
            throw new IOException("Can't read ServerSocketChannel");
        }
        throw new AssertionError();
    }

    public long read(ByteBuffer[] byteBufferArr, int i, int i2) {
        String str = "Can't read ServerSocketChannel";
        if (b) {
            throw new IOException("Can't read ServerSocketChannel");
        }
        throw new AssertionError();
    }
}
