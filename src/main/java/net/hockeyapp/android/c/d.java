package net.hockeyapp.android.c;

import java.io.Serializable;
import java.util.ArrayList;

public class d implements Serializable {
    private String a;
    private String b;
    private int c;
    private String d;
    private ArrayList<f> e;

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public void c(String str) {
        this.d = str;
    }

    public ArrayList<f> a() {
        return this.e;
    }

    public void a(ArrayList<f> arrayList) {
        this.e = arrayList;
    }
}
