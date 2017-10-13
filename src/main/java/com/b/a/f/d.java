package com.b.a.f;

import java.io.File;

public class d {
    public static boolean a(File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        a(listFiles[i]);
                    } else {
                        listFiles[i].delete();
                    }
                }
            }
        }
        return file.delete();
    }
}
