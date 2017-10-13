package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class i {
    public static Scope a(Scope scope) {
        return scope.equals(new Scope("https://www.googleapis.com/auth/fitness.activity.read")) ? new Scope("https://www.googleapis.com/auth/fitness.activity.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.location.read")) ? new Scope("https://www.googleapis.com/auth/fitness.location.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.body.read")) ? new Scope("https://www.googleapis.com/auth/fitness.body.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.nutrition.read")) ? new Scope("https://www.googleapis.com/auth/fitness.nutrition.write") : scope;
    }

    public static Set<Scope> a(Collection<Scope> collection) {
        Set<Scope> hashSet = new HashSet(collection.size());
        for (Scope scope : collection) {
            Scope a = a(scope);
            if (a.equals(scope) || !collection.contains(a)) {
                hashSet.add(scope);
            }
        }
        return hashSet;
    }
}
