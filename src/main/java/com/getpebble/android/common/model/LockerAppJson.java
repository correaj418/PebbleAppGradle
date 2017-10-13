package com.getpebble.android.common.model;

public class LockerAppJson {
    public Application[] applications;
    public String nextPageURL;

    public static class Application {
        public String category;
        public Companions companions;
        public Compatibility compatibility;
        public Developer developer;
        public HardwarePlatform[] hardware_platforms;
        public int hearts;
        public String id;
        public boolean is_configurable;
        public boolean is_timeline_enabled;
        public Links links;
        public Pbw pbw;
        public String title;
        public String type;
        public String user_token;
        public String uuid;
        public String version;

        public static class Companions {
            public CompanionInfo android;

            public static class CompanionInfo {
                public String icon;
                public String id;
                public String name;
                public boolean required;
                public String url;
            }
        }

        public static class Compatibility {
            public CompatibilityInfo android;
            public CompatibilityInfo aplite;
            public CompatibilityInfo basalt;
            public CompatibilityInfo chalk;
            public CompatibilityInfo diorite;

            public static class CompatibilityInfo {
                public boolean supported;
            }
        }

        public static class Developer {
            public String contact_email;
            public String id;
            public String name;
        }

        public static class HardwarePlatform {
            public String description;
            public Image images;
            public String name;
            public int pebble_process_info_flags;
            public String sdk_version;

            public static class Image {
                public String icon;
                public String list;
                public String screenshot;
            }
        }

        public static class Links {
            public String href;
            public String share;
        }

        public static class Pbw {
            public String file;
            public int icon_resource_id;
            public String release_id;
        }
    }
}
