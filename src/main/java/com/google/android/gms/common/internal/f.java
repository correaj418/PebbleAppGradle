package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.a.b;

public class f {
    private final Resources a;
    private final String b = this.a.getResourcePackageName(b.common_google_play_services_unknown_issue);

    public f(Context context) {
        b.a((Object) context);
        this.a = context.getResources();
    }

    public String a(String str) {
        int identifier = this.a.getIdentifier(str, "string", this.b);
        return identifier == 0 ? null : this.a.getString(identifier);
    }
}
