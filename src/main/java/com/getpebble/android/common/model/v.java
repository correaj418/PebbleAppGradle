package com.getpebble.android.common.model;

import com.getpebble.android.common.b.b.a;
import com.google.a.a.f;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class v implements Comparable<v> {
    private int mMajor;
    private int mMinor;
    private int mPoint;
    private String mSuffix;
    private long mTimestamp;
    private String mVersionTag;

    public v(String str, long j) {
        this.mVersionTag = str;
        this.mTimestamp = j;
        parse();
    }

    private void parse() {
        if (this.mVersionTag == null) {
            throw new IllegalArgumentException("'versionTag' is null");
        }
        Matcher matcher = Pattern.compile("[v]?([\\d]+)\\.([\\d]+)\\.?([\\d]*)[\\-]?([\\w\\-\\.]*)").matcher(this.mVersionTag);
        if (matcher.matches()) {
            this.mMajor = Integer.valueOf(matcher.group(1)).intValue();
            this.mMinor = Integer.valueOf(matcher.group(2)).intValue();
            if (matcher.group(3).equals("")) {
                this.mPoint = 0;
            } else {
                this.mPoint = Integer.valueOf(matcher.group(3)).intValue();
            }
            if (!matcher.group(4).equals("")) {
                this.mSuffix = matcher.group(4);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("'versionTag' doesn't match for " + this.mVersionTag + "!");
    }

    public int getMajor() {
        return this.mMajor;
    }

    public int getMinor() {
        return this.mMinor;
    }

    public int getPoint() {
        return this.mPoint;
    }

    public String getSuffix() {
        return this.mSuffix;
    }

    public String getVersionTag() {
        return this.mVersionTag;
    }

    public String getNumberOnlyVersionTag() {
        return f.a('.').a(Integer.valueOf(this.mMajor), Integer.valueOf(this.mMinor), Integer.valueOf(this.mPoint));
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public String toString() {
        return getVersionTag();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            return a.a(((v) obj).getVersionTag(), getVersionTag());
        }
        return false;
    }

    public int hashCode() {
        return this.mVersionTag != null ? this.mVersionTag.hashCode() : 0;
    }

    public int compareTo(v vVar) {
        if (getMajor() < vVar.getMajor()) {
            return -1;
        }
        if (getMajor() > vVar.getMajor()) {
            return 1;
        }
        if (getMinor() < vVar.getMinor()) {
            return -1;
        }
        if (getMinor() > vVar.getMinor()) {
            return 1;
        }
        if (getPoint() < vVar.getPoint()) {
            return -1;
        }
        if (getPoint() > vVar.getPoint()) {
            return 1;
        }
        if (getTimestamp() < vVar.getTimestamp()) {
            return -1;
        }
        if (getTimestamp() > vVar.getTimestamp()) {
            return 1;
        }
        return 0;
    }

    private Long getLongValue(String str) {
        Scanner scanner = new Scanner(str);
        if (scanner.hasNextLong()) {
            return Long.valueOf(scanner.nextLong());
        }
        return null;
    }

    public boolean equalsMajorMinorPoint(v vVar) {
        return this.mMajor == vVar.mMajor && this.mMinor == vVar.mMinor && this.mPoint == vVar.mPoint;
    }
}
