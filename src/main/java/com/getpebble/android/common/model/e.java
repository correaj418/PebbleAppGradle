package com.getpebble.android.common.model;

public class e implements h {
    public String id;
    public String title;
    public String type;
    public String uuid;

    public boolean isValid() {
        if (this.id == null || this.uuid == null) {
            return false;
        }
        return true;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUUID() {
        return this.uuid;
    }

    public String getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }
}
