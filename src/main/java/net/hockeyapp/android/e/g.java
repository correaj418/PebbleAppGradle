package net.hockeyapp.android.e;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class g {
    private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private boolean b = false;
    private boolean c = false;
    private ByteArrayOutputStream d = new ByteArrayOutputStream();
    private String e;

    public g() {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        while (i < 30) {
            stringBuffer.append(a[random.nextInt(a.length)]);
            i++;
        }
        this.e = stringBuffer.toString();
    }

    public String a() {
        return this.e;
    }

    public void b() {
        if (!this.c) {
            this.d.write(("--" + this.e + "\r\n").getBytes());
        }
        this.c = true;
    }

    public void c() {
        if (!this.b) {
            try {
                this.d.write(("\r\n--" + this.e + "--\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.b = true;
        }
    }

    public void a(String str, String str2) {
        b();
        this.d.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n").getBytes());
        this.d.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
        this.d.write("Content-Transfer-Encoding: 8bit\r\n\r\n".getBytes());
        this.d.write(str2.getBytes());
        this.d.write(("\r\n--" + this.e + "\r\n").getBytes());
    }

    public void a(String str, String str2, InputStream inputStream, boolean z) {
        a(str, str2, inputStream, "application/octet-stream", z);
    }

    public void a(String str, String str2, InputStream inputStream, String str3, boolean z) {
        b();
        try {
            String str4 = "Content-Type: " + str3 + "\r\n";
            this.d.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
            this.d.write(str4.getBytes());
            this.d.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                this.d.write(bArr, 0, read);
            }
            this.d.flush();
            if (z) {
                c();
            } else {
                this.d.write(("\r\n--" + this.e + "\r\n").getBytes());
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public long d() {
        c();
        return (long) this.d.toByteArray().length;
    }

    public ByteArrayOutputStream e() {
        c();
        return this.d;
    }
}
