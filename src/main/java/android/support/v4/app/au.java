package android.support.v4.app;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.at.a;

class au {
    static a a(Bundle bundle, a.a aVar) {
        return aVar.b(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), bundle.getBundle("extras"));
    }

    static Bundle a(a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", aVar.a());
        bundle.putCharSequence("label", aVar.b());
        bundle.putCharSequenceArray("choices", aVar.c());
        bundle.putBoolean("allowFreeFormInput", aVar.d());
        bundle.putBundle("extras", aVar.e());
        return bundle;
    }

    static a[] a(Bundle[] bundleArr, a.a aVar) {
        if (bundleArr == null) {
            return null;
        }
        a[] b = aVar.b(bundleArr.length);
        for (int i = 0; i < bundleArr.length; i++) {
            b[i] = a(bundleArr[i], aVar);
        }
        return b;
    }

    static Bundle[] a(a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            bundleArr[i] = a(aVarArr[i]);
        }
        return bundleArr;
    }

    static void a(a[] aVarArr, Intent intent, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        for (a aVar : aVarArr) {
            Object obj = bundle.get(aVar.a());
            if (obj instanceof CharSequence) {
                bundle2.putCharSequence(aVar.a(), (CharSequence) obj);
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra("android.remoteinput.resultsData", bundle2);
        intent.setClipData(ClipData.newIntent("android.remoteinput.results", intent2));
    }
}
