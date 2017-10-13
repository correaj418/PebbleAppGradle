package com.b.a.f;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class g {
    public static byte[] a(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = dataInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                dataInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
