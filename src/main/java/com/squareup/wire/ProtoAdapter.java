package com.squareup.wire;

import b.a;
import b.b;
import b.c;
import b.d;
import b.e;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.WireField.Label;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL = new ProtoAdapter<Boolean>(FieldEncoding.VARINT, Boolean.class) {
        public int encodedSize(Boolean bool) {
            return 1;
        }

        public void encode(ProtoWriter protoWriter, Boolean bool) {
            protoWriter.writeVarint32(bool.booleanValue() ? 1 : 0);
        }

        public Boolean decode(ProtoReader protoReader) {
            int readVarint32 = protoReader.readVarint32();
            if (readVarint32 == 0) {
                return Boolean.FALSE;
            }
            if (readVarint32 == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", new Object[]{Integer.valueOf(readVarint32)}));
        }
    };
    public static final ProtoAdapter<d> BYTES = new ProtoAdapter<d>(FieldEncoding.LENGTH_DELIMITED, d.class) {
        public int encodedSize(d dVar) {
            return dVar.c();
        }

        public void encode(ProtoWriter protoWriter, d dVar) {
            protoWriter.writeBytes(dVar);
        }

        public d decode(ProtoReader protoReader) {
            return protoReader.readBytes();
        }
    };
    public static final ProtoAdapter<Double> DOUBLE = new ProtoAdapter<Double>(FieldEncoding.FIXED64, Double.class) {
        public int encodedSize(Double d) {
            return 8;
        }

        public void encode(ProtoWriter protoWriter, Double d) {
            protoWriter.writeFixed64(Double.doubleToLongBits(d.doubleValue()));
        }

        public Double decode(ProtoReader protoReader) {
            return Double.valueOf(Double.longBitsToDouble(protoReader.readFixed64()));
        }
    };
    public static final ProtoAdapter<Integer> FIXED32 = new ProtoAdapter<Integer>(FieldEncoding.FIXED32, Integer.class) {
        public int encodedSize(Integer num) {
            return 4;
        }

        public void encode(ProtoWriter protoWriter, Integer num) {
            protoWriter.writeFixed32(num.intValue());
        }

        public Integer decode(ProtoReader protoReader) {
            return Integer.valueOf(protoReader.readFixed32());
        }
    };
    public static final ProtoAdapter<Long> FIXED64 = new ProtoAdapter<Long>(FieldEncoding.FIXED64, Long.class) {
        public int encodedSize(Long l) {
            return 8;
        }

        public void encode(ProtoWriter protoWriter, Long l) {
            protoWriter.writeFixed64(l.longValue());
        }

        public Long decode(ProtoReader protoReader) {
            return Long.valueOf(protoReader.readFixed64());
        }
    };
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter<Float> FLOAT = new ProtoAdapter<Float>(FieldEncoding.FIXED32, Float.class) {
        public int encodedSize(Float f) {
            return 4;
        }

        public void encode(ProtoWriter protoWriter, Float f) {
            protoWriter.writeFixed32(Float.floatToIntBits(f.floatValue()));
        }

        public Float decode(ProtoReader protoReader) {
            return Float.valueOf(Float.intBitsToFloat(protoReader.readFixed32()));
        }
    };
    public static final ProtoAdapter<Integer> INT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) {
        public int encodedSize(Integer num) {
            return ProtoWriter.int32Size(num.intValue());
        }

        public void encode(ProtoWriter protoWriter, Integer num) {
            protoWriter.writeSignedVarint32(num.intValue());
        }

        public Integer decode(ProtoReader protoReader) {
            return Integer.valueOf(protoReader.readVarint32());
        }
    };
    public static final ProtoAdapter<Long> INT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) {
        public int encodedSize(Long l) {
            return ProtoWriter.varint64Size(l.longValue());
        }

        public void encode(ProtoWriter protoWriter, Long l) {
            protoWriter.writeVarint64(l.longValue());
        }

        public Long decode(ProtoReader protoReader) {
            return Long.valueOf(protoReader.readVarint64());
        }
    };
    public static final ProtoAdapter<Integer> SFIXED32 = FIXED32;
    public static final ProtoAdapter<Long> SFIXED64 = FIXED64;
    public static final ProtoAdapter<Integer> SINT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) {
        public int encodedSize(Integer num) {
            return ProtoWriter.varint32Size(ProtoWriter.encodeZigZag32(num.intValue()));
        }

        public void encode(ProtoWriter protoWriter, Integer num) {
            protoWriter.writeVarint32(ProtoWriter.encodeZigZag32(num.intValue()));
        }

        public Integer decode(ProtoReader protoReader) {
            return Integer.valueOf(ProtoWriter.decodeZigZag32(protoReader.readVarint32()));
        }
    };
    public static final ProtoAdapter<Long> SINT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) {
        public int encodedSize(Long l) {
            return ProtoWriter.varint64Size(ProtoWriter.encodeZigZag64(l.longValue()));
        }

        public void encode(ProtoWriter protoWriter, Long l) {
            protoWriter.writeVarint64(ProtoWriter.encodeZigZag64(l.longValue()));
        }

        public Long decode(ProtoReader protoReader) {
            return Long.valueOf(ProtoWriter.decodeZigZag64(protoReader.readVarint64()));
        }
    };
    public static final ProtoAdapter<String> STRING = new ProtoAdapter<String>(FieldEncoding.LENGTH_DELIMITED, String.class) {
        public int encodedSize(String str) {
            return ProtoWriter.utf8Length(str);
        }

        public void encode(ProtoWriter protoWriter, String str) {
            protoWriter.writeString(str);
        }

        public String decode(ProtoReader protoReader) {
            return protoReader.readString();
        }
    };
    public static final ProtoAdapter<Integer> UINT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) {
        public int encodedSize(Integer num) {
            return ProtoWriter.varint32Size(num.intValue());
        }

        public void encode(ProtoWriter protoWriter, Integer num) {
            protoWriter.writeVarint32(num.intValue());
        }

        public Integer decode(ProtoReader protoReader) {
            return Integer.valueOf(protoReader.readVarint32());
        }
    };
    public static final ProtoAdapter<Long> UINT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) {
        public int encodedSize(Long l) {
            return ProtoWriter.varint64Size(l.longValue());
        }

        public void encode(ProtoWriter protoWriter, Long l) {
            protoWriter.writeVarint64(l.longValue());
        }

        public Long decode(ProtoReader protoReader) {
            return Long.valueOf(protoReader.readVarint64());
        }
    };
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;

    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        EnumConstantNotFoundException(int i, Class<?> cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            this.value = i;
        }
    }

    private static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Entry<K, V>> {
        final ProtoAdapter<K> keyAdapter;
        final ProtoAdapter<V> valueAdapter;

        MapEntryProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = protoAdapter;
            this.valueAdapter = protoAdapter2;
        }

        public int encodedSize(Entry<K, V> entry) {
            return this.keyAdapter.encodedSizeWithTag(1, entry.getKey()) + this.valueAdapter.encodedSizeWithTag(2, entry.getValue());
        }

        public void encode(ProtoWriter protoWriter, Entry<K, V> entry) {
            this.keyAdapter.encodeWithTag(protoWriter, 1, entry.getKey());
            this.valueAdapter.encodeWithTag(protoWriter, 2, entry.getValue());
        }

        public Entry<K, V> decode(ProtoReader protoReader) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {
        private final MapEntryProtoAdapter<K, V> entryAdapter;

        MapProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new MapEntryProtoAdapter(protoAdapter, protoAdapter2);
        }

        public int encodedSize(Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        public int encodedSizeWithTag(int i, Map<K, V> map) {
            int i2 = 0;
            for (Entry encodedSizeWithTag : map.entrySet()) {
                i2 = this.entryAdapter.encodedSizeWithTag(i, encodedSizeWithTag) + i2;
            }
            return i2;
        }

        public void encode(ProtoWriter protoWriter, Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        public void encodeWithTag(ProtoWriter protoWriter, int i, Map<K, V> map) {
            for (Entry encodeWithTag : map.entrySet()) {
                this.entryAdapter.encodeWithTag(protoWriter, i, encodeWithTag);
            }
        }

        public Map<K, V> decode(ProtoReader protoReader) {
            Object obj = null;
            long beginMessage = protoReader.beginMessage();
            Object obj2 = null;
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            obj2 = this.entryAdapter.keyAdapter.decode(protoReader);
                            break;
                        case 2:
                            obj = this.entryAdapter.valueAdapter.decode(protoReader);
                            break;
                        default:
                            break;
                    }
                }
                protoReader.endMessage(beginMessage);
                if (obj2 == null) {
                    throw new IllegalStateException("Map entry with null key");
                } else if (obj != null) {
                    return Collections.singletonMap(obj2, obj);
                } else {
                    throw new IllegalStateException("Map entry with null value");
                }
            }
        }

        public Map<K, V> redact(Map<K, V> map) {
            return Collections.emptyMap();
        }
    }

    public abstract E decode(ProtoReader protoReader);

    public abstract void encode(ProtoWriter protoWriter, E e);

    public abstract int encodedSize(E e);

    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls) {
        this.fieldEncoding = fieldEncoding;
        this.javaType = cls;
    }

    public static <M extends Message<M, B>, B extends Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return RuntimeMessageAdapter.create(cls);
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> cls) {
        return new RuntimeEnumAdapter(cls);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return new MapProtoAdapter(protoAdapter, protoAdapter2);
    }

    public static <M extends Message> ProtoAdapter<M> get(M m) {
        return get(m.getClass());
    }

    public static <M> ProtoAdapter<M> get(Class<M> cls) {
        Throwable e;
        try {
            return (ProtoAdapter) cls.getField("ADAPTER").get(null);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e);
        } catch (NoSuchFieldException e3) {
            e = e3;
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e);
        }
    }

    static ProtoAdapter<?> get(String str) {
        Throwable e;
        try {
            int indexOf = str.indexOf(35);
            String substring = str.substring(0, indexOf);
            return (ProtoAdapter) Class.forName(substring).getField(str.substring(indexOf + 1)).get(null);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new IllegalArgumentException("failed to access " + str, e);
        } catch (NoSuchFieldException e3) {
            e = e3;
            throw new IllegalArgumentException("failed to access " + str, e);
        } catch (ClassNotFoundException e4) {
            e = e4;
            throw new IllegalArgumentException("failed to access " + str, e);
        }
    }

    public E redact(E e) {
        return null;
    }

    public int encodedSizeWithTag(int i, E e) {
        int encodedSize = encodedSize(e);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.varint32Size(encodedSize);
        }
        return encodedSize + ProtoWriter.tagSize(i);
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, E e) {
        protoWriter.writeTag(i, this.fieldEncoding);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            protoWriter.writeVarint32(encodedSize(e));
        }
        encode(protoWriter, (Object) e);
    }

    public final void encode(b bVar, E e) {
        Preconditions.checkNotNull(e, "value == null");
        Preconditions.checkNotNull(bVar, "sink == null");
        encode(new ProtoWriter(bVar), (Object) e);
    }

    public final byte[] encode(E e) {
        Preconditions.checkNotNull(e, "value == null");
        b aVar = new a();
        try {
            encode(aVar, (Object) e);
            return aVar.k();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void encode(OutputStream outputStream, E e) {
        Preconditions.checkNotNull(e, "value == null");
        Preconditions.checkNotNull(outputStream, "stream == null");
        b a = e.a(e.a(outputStream));
        encode(a, (Object) e);
        a.b();
    }

    public final E decode(byte[] bArr) {
        Preconditions.checkNotNull(bArr, "bytes == null");
        return decode(new a().b(bArr));
    }

    public final E decode(d dVar) {
        Preconditions.checkNotNull(dVar, "bytes == null");
        return decode(new a().a(dVar));
    }

    public final E decode(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream, "stream == null");
        return decode(e.a(e.a(inputStream)));
    }

    public final E decode(c cVar) {
        Preconditions.checkNotNull(cVar, "source == null");
        return decode(new ProtoReader(cVar));
    }

    public String toString(E e) {
        return e.toString();
    }

    ProtoAdapter<?> withLabel(Label label) {
        if (!label.isRepeated()) {
            return this;
        }
        if (label.isPacked()) {
            return asPacked();
        }
        return asRepeated();
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        protoAdapter = createPacked();
        this.packedAdapter = protoAdapter;
        return protoAdapter;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        protoAdapter = createRepeated();
        this.repeatedAdapter = protoAdapter;
        return protoAdapter;
    }

    private ProtoAdapter<List<E>> createPacked() {
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) {
            return new ProtoAdapter<List<E>>(FieldEncoding.LENGTH_DELIMITED, List.class) {
                public void encodeWithTag(ProtoWriter protoWriter, int i, List<E> list) {
                    if (!list.isEmpty()) {
                        super.encodeWithTag(protoWriter, i, list);
                    }
                }

                public int encodedSize(List<E> list) {
                    int i = 0;
                    int i2 = 0;
                    while (i < list.size()) {
                        i2 += ProtoAdapter.this.encodedSize(list.get(i));
                        i++;
                    }
                    return i2;
                }

                public int encodedSizeWithTag(int i, List<E> list) {
                    return list.isEmpty() ? 0 : super.encodedSizeWithTag(i, list);
                }

                public void encode(ProtoWriter protoWriter, List<E> list) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        ProtoAdapter.this.encode(protoWriter, list.get(i));
                    }
                }

                public List<E> decode(ProtoReader protoReader) {
                    return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
                }

                public List<E> redact(List<E> list) {
                    return Collections.emptyList();
                }
            };
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        return new ProtoAdapter<List<E>>(this.fieldEncoding, List.class) {
            public int encodedSize(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }

            public int encodedSizeWithTag(int i, List<E> list) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < list.size()) {
                    i3 += ProtoAdapter.this.encodedSizeWithTag(i, list.get(i2));
                    i2++;
                }
                return i3;
            }

            public void encode(ProtoWriter protoWriter, List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            public void encodeWithTag(ProtoWriter protoWriter, int i, List<E> list) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ProtoAdapter.this.encodeWithTag(protoWriter, i, list.get(i2));
                }
            }

            public List<E> decode(ProtoReader protoReader) {
                return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
            }

            public List<E> redact(List<E> list) {
                return Collections.emptyList();
            }
        };
    }
}
