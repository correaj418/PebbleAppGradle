package com.getpebble.android.framework.a;

import android.net.Uri;
import android.net.Uri.Builder;
import com.getpebble.android.common.model.an;
import java.util.UUID;

public class d {
    private final Uri a;
    private final UUID b;
    private final UUID c;

    public d(UUID uuid, UUID uuid2) {
        Builder builder = new Builder();
        builder.authority("pebble");
        builder.appendQueryParameter(an.SOURCE, uuid2.toString());
        builder.appendQueryParameter("pin", uuid.toString());
        this.a = builder.build();
        this.b = uuid;
        this.c = uuid2;
    }

    public d(Uri uri) {
        if (uri.isHierarchical()) {
            String queryParameter = uri.getQueryParameter("pin");
            String queryParameter2 = uri.getQueryParameter(an.SOURCE);
            if (queryParameter == null || queryParameter2 == null) {
                throw new IllegalArgumentException("Metadata URI did not contain Pebble metadata. " + "");
            }
            this.b = UUID.fromString(queryParameter);
            this.c = UUID.fromString(queryParameter2);
            if (this.b == null || this.c == null) {
                throw new IllegalStateException("Metadata URI contained malformed Pebble metadata. " + "");
            } else {
                this.a = uri;
                return;
            }
        }
        throw new IllegalArgumentException("Metadata URI contained non-hierarchical metadata not created by Pebble. " + "");
    }

    public Uri a() {
        return this.a;
    }

    public UUID b() {
        return this.b;
    }

    public UUID c() {
        return this.c;
    }
}
