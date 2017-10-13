package b;

import java.io.InterruptedIOException;

public class m {
    public static final m a = new m() {
        public void a() {
        }
    };
    private boolean b;
    private long c;

    public void a() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.b && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
