package net.hockeyapp.android.c;

public enum a {
    CrashManagerUserInputDontSend(0),
    CrashManagerUserInputSend(1),
    CrashManagerUserInputAlwaysSend(2);
    
    private final int mValue;

    private a(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
