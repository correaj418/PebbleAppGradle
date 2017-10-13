package com.b.a;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

class aa extends l {
    SocketChannel a;

    aa(SocketChannel socketChannel) {
        super(socketChannel);
        this.a = socketChannel;
    }

    public int read(ByteBuffer byteBuffer) {
        return this.a.read(byteBuffer);
    }

    public boolean b() {
        return this.a.isConnected();
    }

    public int a(ByteBuffer[] byteBufferArr) {
        return (int) this.a.write(byteBufferArr);
    }

    public void a() {
        try {
            this.a.socket().shutdownOutput();
        } catch (Exception e) {
        }
    }

    public long read(ByteBuffer[] byteBufferArr) {
        return this.a.read(byteBufferArr);
    }

    public long read(ByteBuffer[] byteBufferArr, int i, int i2) {
        return this.a.read(byteBufferArr, i, i2);
    }
}
