package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.d.d;
import android.support.v4.d.e;

public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = d.a(new e<AbsSavedState>() {
        public /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
            return b(parcel, classLoader);
        }

        public /* synthetic */ Object[] a(int i) {
            return b(i);
        }

        public AbsSavedState b(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.a;
            }
            throw new IllegalStateException("superState must be null");
        }

        public AbsSavedState[] b(int i) {
            return new AbsSavedState[i];
        }
    });
    public static final AbsSavedState a = new AbsSavedState() {
    };
    private final Parcelable b;

    private AbsSavedState() {
        this.b = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == a) {
            parcelable = null;
        }
        this.b = parcelable;
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = a;
        }
        this.b = readParcelable;
    }

    public final Parcelable a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
    }
}
