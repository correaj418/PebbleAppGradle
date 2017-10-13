package com.b.a.c;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class o {
    private static final ThreadLocal<DateFormat> a = new ThreadLocal<DateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected DateFormat a() {
            DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };
    private static final String[] b = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};

    public static Date a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return ((DateFormat) a.get()).parse(str);
        } catch (ParseException e) {
            String[] strArr = b;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return new SimpleDateFormat(strArr[i], Locale.US).parse(str);
                } catch (ParseException e2) {
                    i++;
                }
            }
            return null;
        }
    }

    public static String a(Date date) {
        return ((DateFormat) a.get()).format(date);
    }
}
