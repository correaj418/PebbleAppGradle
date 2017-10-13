package com.a.a.a;

import java.net.URLEncoder;
import java.util.List;

public class h {
    protected String A;
    protected String B;
    protected String C;
    protected String D;
    protected Integer E;
    protected Boolean F;
    protected Boolean G;
    protected Boolean H;
    protected Boolean I;
    protected b J;
    protected c K;
    protected String L;
    protected int M;
    protected int N;
    protected List<String> a;
    protected List<String> b;
    protected List<String> c;
    protected List<String> d;
    protected Integer e;
    protected Integer f;
    protected Boolean g;
    protected Boolean h;
    protected Integer i;
    protected Boolean j;
    protected Boolean k;
    protected Integer l;
    protected Integer m;
    protected String n;
    protected String o;
    protected String p;
    protected String q;
    protected Integer r;
    protected String s;
    protected String t;
    protected String u;
    protected String v;
    protected Boolean w;
    protected String x;
    protected String y;
    protected a z;

    public enum a {
        PREFIX_ALL,
        PREFIX_LAST,
        PREFIX_NONE,
        PREFIX_NOTSET
    }

    public enum b {
        REMOVE_LAST_WORDS,
        REMOVE_FIRST_WORDS,
        REMOVE_NONE,
        REMOVE_ALLOPTIONAL,
        REMOVE_NOTSET
    }

    public enum c {
        TYPO_TRUE,
        TYPO_FALSE,
        TYPO_MIN,
        TYPO_STRICT,
        TYPO_NOTSET
    }

    public h(String str) {
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.r = null;
        this.m = null;
        this.x = str;
        this.y = null;
        this.z = a.PREFIX_NOTSET;
        this.E = null;
        this.j = null;
        this.k = null;
        this.I = null;
        this.H = null;
        this.G = null;
        this.F = null;
        this.L = null;
        this.K = c.TYPO_NOTSET;
        this.J = b.REMOVE_NOTSET;
        this.N = 0;
        this.M = 0;
    }

    public h() {
        this((String) null);
    }

    public h a(String str) {
        this.L = str;
        return this;
    }

    public h a(int i) {
        this.l = Integer.valueOf(i);
        return this;
    }

    public h b(int i) {
        this.m = Integer.valueOf(i);
        return this;
    }

    public h b(String str) {
        this.o = str;
        return this;
    }

    protected String a() {
        Object obj = 1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Object obj2;
            StringBuilder append;
            char c;
            if (this.a != null) {
                stringBuilder.append("attributes=");
                obj2 = 1;
                for (String str : this.a) {
                    if (obj2 == null) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
                    obj2 = null;
                }
            }
            if (this.b != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("attributesToHighlight=");
                obj2 = 1;
                for (String str2 : this.b) {
                    if (obj2 == null) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
                    obj2 = null;
                }
            }
            if (this.c != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("attributesToSnippet=");
                obj2 = 1;
                for (String str22 : this.c) {
                    if (obj2 == null) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append(URLEncoder.encode(str22, "UTF-8"));
                    obj2 = null;
                }
            }
            if (this.d != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("disableTypoToleranceOnAttributes=");
                for (String str222 : this.d) {
                    if (obj == null) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append(URLEncoder.encode(str222, "UTF-8"));
                    obj = null;
                }
            }
            if (this.K != c.TYPO_NOTSET) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("typoTolerance=");
                switch (this.K) {
                    case TYPO_FALSE:
                        stringBuilder.append("false");
                        break;
                    case TYPO_MIN:
                        stringBuilder.append("min");
                        break;
                    case TYPO_STRICT:
                        stringBuilder.append("strict");
                        break;
                    case TYPO_TRUE:
                        stringBuilder.append("true");
                        break;
                    case TYPO_NOTSET:
                        throw new IllegalStateException("code not reachable");
                }
            }
            if (this.I != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                append = stringBuilder.append("allowTyposOnNumericTokens=");
                if (this.I.booleanValue()) {
                    c = '1';
                } else {
                    c = '0';
                }
                append.append(c);
            }
            if (this.e != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("minWordSizefor1Typo=");
                stringBuilder.append(this.e);
            }
            if (this.f != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("minWordSizefor2Typos=");
                stringBuilder.append(this.f);
            }
            switch (this.J) {
                case REMOVE_LAST_WORDS:
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('&');
                    }
                    stringBuilder.append("removeWordsIfNoResult=LastWords");
                    break;
                case REMOVE_FIRST_WORDS:
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('&');
                    }
                    stringBuilder.append("removeWordsIfNoResult=FirstWords");
                    break;
                case REMOVE_ALLOPTIONAL:
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('&');
                    }
                    stringBuilder.append("removeWordsIfNoResult=allOptional");
                    break;
                case REMOVE_NONE:
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('&');
                    }
                    stringBuilder.append("removeWordsIfNoResult=none");
                    break;
            }
            if (this.g != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                append = stringBuilder.append("getRankingInfo=");
                if (this.g.booleanValue()) {
                    c = '1';
                } else {
                    c = '0';
                }
                append.append(c);
            }
            if (this.h != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                append = stringBuilder.append("ignorePlural=");
                if (this.h.booleanValue()) {
                    c = '1';
                } else {
                    c = '0';
                }
                append.append(c);
            }
            if (this.F != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                append = stringBuilder.append("analytics=");
                if (this.F.booleanValue()) {
                    c = '1';
                } else {
                    c = '0';
                }
                append.append(c);
            }
            if (this.L != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("analyticsTags=" + this.L);
            }
            if (this.G != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                append = stringBuilder.append("synonyms=");
                if (this.G.booleanValue()) {
                    c = '1';
                } else {
                    c = '0';
                }
                append.append(c);
            }
            if (this.H != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                append = stringBuilder.append("replaceSynonymsInHighlight=");
                if (this.H.booleanValue()) {
                    c = '1';
                } else {
                    c = '0';
                }
                append.append(c);
            }
            if (this.i != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("distinct=");
                stringBuilder.append(this.i);
            }
            if (this.j != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("advancedSyntax=").append(this.j.booleanValue() ? '1' : '0');
            }
            if (this.k != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                append = stringBuilder.append("removeStopWords=");
                if (this.k.booleanValue()) {
                    c = '1';
                } else {
                    c = '0';
                }
                append.append(c);
            }
            if (this.l != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("page=");
                stringBuilder.append(this.l);
            }
            if (this.r != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("minProximity=");
                stringBuilder.append(this.r);
            }
            if (!(this.p == null || this.q == null)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("highlightPreTag=");
                stringBuilder.append(this.p);
                stringBuilder.append("&highlightPostTag=");
                stringBuilder.append(this.q);
            }
            if (this.m != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("hitsPerPage=");
                stringBuilder.append(this.m);
            }
            if (this.o != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("tagFilters=");
                stringBuilder.append(URLEncoder.encode(this.o, "UTF-8"));
            }
            if (this.s != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("numericFilters=");
                stringBuilder.append(URLEncoder.encode(this.s, "UTF-8"));
            }
            if (this.t != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append(this.t);
            }
            if (this.v != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append(this.v);
            }
            if (this.u != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append(this.u);
            }
            if (this.N > 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("aroundRadius=" + this.N);
            }
            if (this.M > 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("aroundPrecision=" + this.M);
            }
            if (this.w != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("aroundLatLngViaIP=").append(this.w.booleanValue() ? '1' : '0');
            }
            if (this.x != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("query=");
                stringBuilder.append(URLEncoder.encode(this.x, "UTF-8"));
            }
            if (this.y != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("similarQuery=");
                stringBuilder.append(URLEncoder.encode(this.y, "UTF-8"));
            }
            if (this.B != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("facets=");
                stringBuilder.append(URLEncoder.encode(this.B, "UTF-8"));
            }
            if (this.C != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("filters=");
                stringBuilder.append(URLEncoder.encode(this.C, "UTF-8"));
            }
            if (this.D != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("facetFilters=");
                stringBuilder.append(URLEncoder.encode(this.D, "UTF-8"));
            }
            if (this.E != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("maxNumberOfFacets=");
                stringBuilder.append(this.E);
            }
            if (this.A != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("optionalWords=");
                stringBuilder.append(URLEncoder.encode(this.A, "UTF-8"));
            }
            if (this.n != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("restrictSearchableAttributes=");
                stringBuilder.append(URLEncoder.encode(this.n, "UTF-8"));
            }
            switch (this.z) {
                case PREFIX_ALL:
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('&');
                    }
                    stringBuilder.append("queryType=prefixAll");
                    break;
                case PREFIX_LAST:
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('&');
                    }
                    stringBuilder.append("queryType=prefixLast");
                    break;
                case PREFIX_NONE:
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('&');
                    }
                    stringBuilder.append("queryType=prefixNone");
                    break;
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
