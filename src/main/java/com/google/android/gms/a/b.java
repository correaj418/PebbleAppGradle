package com.google.android.gms.a;

import android.os.IBinder;
import com.google.android.gms.a.a.a;
import java.lang.reflect.Field;

public final class b<T> extends a {
    private final T a;

    private b(T t) {
        this.a = t;
    }

    public static <T> a a(T t) {
        return new b(t);
    }

    public static <T> T a(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
