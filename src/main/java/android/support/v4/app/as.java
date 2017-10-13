package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.at.a;

class as {
    static a[] a(RemoteInput[] remoteInputArr, a.a aVar) {
        if (remoteInputArr == null) {
            return null;
        }
        a[] b = aVar.b(remoteInputArr.length);
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInput remoteInput = remoteInputArr[i];
            b[i] = aVar.b(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
        }
        return b;
    }

    static RemoteInput[] a(a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            a aVar = aVarArr[i];
            remoteInputArr[i] = new Builder(aVar.a()).setLabel(aVar.b()).setChoices(aVar.c()).setAllowFreeFormInput(aVar.d()).addExtras(aVar.e()).build();
        }
        return remoteInputArr;
    }

    static void a(a[] aVarArr, Intent intent, Bundle bundle) {
        RemoteInput.addResultsToIntent(a(aVarArr), intent, bundle);
    }
}
