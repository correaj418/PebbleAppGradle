package com.b.b.b;

public interface c {

    public interface a {

        public interface c extends d {
        }

        public interface a extends c, j<c, a, e, f> {
        }

        public interface d extends f {
        }

        public interface b extends b, d {
        }

        public interface e extends c, i<e> {
        }

        public interface f extends c {
        }
    }

    public interface b {

        public interface a<A extends a<?>> extends b<A>, f<A>, h {
        }
    }
}
