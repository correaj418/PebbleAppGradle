package com.b.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Service;
import android.content.Context;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class d<T> extends WeakReference<T> {

    static abstract class c<T extends Context> extends d<T> {
        c(T t) {
            super(t);
        }

        static String b(Context context) {
            if (context instanceof Service) {
                return d.a((Service) context);
            }
            if (context instanceof Activity) {
                return a.a((Activity) context);
            }
            return null;
        }

        public Context b() {
            return (Context) get();
        }
    }

    static class a extends c<Activity> {
        public a(Activity activity) {
            super(activity);
        }

        static String a(Activity activity) {
            if (activity == null) {
                return "Activity reference null";
            }
            if (activity.isFinishing()) {
                return "Activity finished";
            }
            return null;
        }

        public String a() {
            return a((Activity) get());
        }
    }

    static class b extends d<ImageView> {
        public b(ImageView imageView) {
            super(imageView);
        }

        public String a() {
            ImageView imageView = (ImageView) get();
            if (imageView == null) {
                return "ImageView reference null";
            }
            return c.b(imageView.getContext());
        }

        public Context b() {
            ImageView imageView = (ImageView) get();
            if (imageView == null) {
                return null;
            }
            return imageView.getContext();
        }
    }

    static class d extends c<Service> {
        public d(Service service) {
            super(service);
        }

        static String a(Service service) {
            if (service == null) {
                return "Service reference null";
            }
            List<RunningServiceInfo> runningServices = ((ActivityManager) service.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null) {
                return "Could not retrieve services from service manager";
            }
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                if (service.getClass().getName().equals(runningServiceInfo.service.getClassName())) {
                    return null;
                }
            }
            return "Service stopped";
        }

        public String a() {
            return a((Service) get());
        }
    }

    public abstract String a();

    public abstract Context b();

    d(T t) {
        super(t);
    }

    public static d a(Context context) {
        if (context instanceof Service) {
            return new d((Service) context);
        }
        if (context instanceof Activity) {
            return new a((Activity) context);
        }
        return new c<Context>(context) {
            public String a() {
                if (((Context) get()) == null) {
                    return "Context reference null";
                }
                return null;
            }
        };
    }
}
