package net.hockeyapp.android.c;

public class b {
    private String a;
    private String b;
    private String c;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String toString() {
        return "\n" + b.class.getSimpleName() + "\n" + "userDescription " + this.a + "\n" + "userEmail       " + this.b + "\n" + "userID          " + this.c;
    }
}
