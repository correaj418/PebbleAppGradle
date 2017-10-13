package com.a.a.a;

import android.os.AsyncTask;

public class e extends d {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[f.values().length];

        static {
            try {
                a[f.AddObject.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[f.AddObjectWithObjectID.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[f.AddObjects.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[f.SaveObject.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[f.SaveObjects.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[f.PartialUpdateObject.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[f.PartialUpdateObjects.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[f.GetObject.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[f.GetObjectWithAttributesToRetrieve.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[f.GetObjects.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[f.DeleteObject.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[f.DeleteObjects.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[f.DeleteByQuery.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[f.GetSettings.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                a[f.SetSettings.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    private class a extends AsyncTask<com.a.a.a.i.a, Void, com.a.a.a.i.a> {
        final /* synthetic */ e a;

        private a(e eVar) {
            this.a = eVar;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((com.a.a.a.i.a[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            a((com.a.a.a.i.a) obj);
        }

        protected com.a.a.a.i.a a(com.a.a.a.i.a... aVarArr) {
            com.a.a.a.i.a aVar = aVarArr[0];
            try {
                aVar.c = this.a.a(aVar.b);
            } catch (b e) {
                aVar.d = e;
            }
            return aVar;
        }

        protected void a(com.a.a.a.i.a aVar) {
            aVar.a(this.a);
        }
    }

    protected e(a aVar, String str) {
        super(aVar, str);
    }

    public void a(h hVar, com.a.a.a.a.a aVar) {
        com.a.a.a.i.a aVar2 = new com.a.a.a.i.a(aVar, hVar);
        new a().execute(new com.a.a.a.i.a[]{aVar2});
    }
}
