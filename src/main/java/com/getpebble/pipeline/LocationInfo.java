package com.getpebble.pipeline;

import b.d;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
import com.squareup.wire.internal.Internal;

public final class LocationInfo extends Message<LocationInfo, Builder> {
    public static final ProtoAdapter<LocationInfo> ADAPTER = new ProtoAdapter_LocationInfo();
    public static final String DEFAULT_IP_ADDRESS = "";
    public static final String DEFAULT_LOCATION_STR = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.getpebble.pipeline.LocationInfo$LatLon#ADAPTER", tag = 1)
    public final LatLon geo;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String ip_address;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String location_str;

    public static final class Builder extends com.squareup.wire.Message.Builder<LocationInfo, Builder> {
        public LatLon geo;
        public String ip_address;
        public String location_str;

        public Builder geo(LatLon latLon) {
            this.geo = latLon;
            return this;
        }

        public Builder ip_address(String str) {
            this.ip_address = str;
            return this;
        }

        public Builder location_str(String str) {
            this.location_str = str;
            return this;
        }

        public LocationInfo build() {
            return new LocationInfo(this.geo, this.ip_address, this.location_str, super.buildUnknownFields());
        }
    }

    public static final class LatLon extends Message<LatLon, Builder> {
        public static final ProtoAdapter<LatLon> ADAPTER = new ProtoAdapter_LatLon();
        public static final Float DEFAULT_LAT = Float.valueOf(0.0f);
        public static final Float DEFAULT_LON = Float.valueOf(0.0f);
        private static final long serialVersionUID = 0;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = Label.REQUIRED, tag = 1)
        public final Float lat;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = Label.REQUIRED, tag = 2)
        public final Float lon;

        public static final class Builder extends com.squareup.wire.Message.Builder<LatLon, Builder> {
            public Float lat;
            public Float lon;

            public Builder lat(Float f) {
                this.lat = f;
                return this;
            }

            public Builder lon(Float f) {
                this.lon = f;
                return this;
            }

            public LatLon build() {
                if (this.lat != null && this.lon != null) {
                    return new LatLon(this.lat, this.lon, super.buildUnknownFields());
                }
                throw Internal.missingRequiredFields(this.lat, "lat", this.lon, "lon");
            }
        }

        private static final class ProtoAdapter_LatLon extends ProtoAdapter<LatLon> {
            ProtoAdapter_LatLon() {
                super(FieldEncoding.LENGTH_DELIMITED, LatLon.class);
            }

            public int encodedSize(LatLon latLon) {
                return (ProtoAdapter.FLOAT.encodedSizeWithTag(1, latLon.lat) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, latLon.lon)) + latLon.unknownFields().c();
            }

            public void encode(ProtoWriter protoWriter, LatLon latLon) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, latLon.lat);
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, latLon.lon);
                protoWriter.writeBytes(latLon.unknownFields());
            }

            public LatLon decode(ProtoReader protoReader) {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                builder.lat((Float) ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 2:
                                builder.lon((Float) ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            default:
                                FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                break;
                        }
                    }
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }

            public LatLon redact(LatLon latLon) {
                Builder newBuilder = latLon.newBuilder();
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }

        public LatLon(Float f, Float f2) {
            this(f, f2, d.b);
        }

        public LatLon(Float f, Float f2, d dVar) {
            super(ADAPTER, dVar);
            this.lat = f;
            this.lon = f2;
        }

        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.lat = this.lat;
            builder.lon = this.lon;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LatLon)) {
                return false;
            }
            LatLon latLon = (LatLon) obj;
            if (unknownFields().equals(latLon.unknownFields()) && this.lat.equals(latLon.lat) && this.lon.equals(latLon.lon)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            i = (((unknownFields().hashCode() * 37) + this.lat.hashCode()) * 37) + this.lon.hashCode();
            this.hashCode = i;
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(", lat=").append(this.lat);
            stringBuilder.append(", lon=").append(this.lon);
            return stringBuilder.replace(0, 2, "LatLon{").append('}').toString();
        }
    }

    private static final class ProtoAdapter_LocationInfo extends ProtoAdapter<LocationInfo> {
        ProtoAdapter_LocationInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LocationInfo.class);
        }

        public int encodedSize(LocationInfo locationInfo) {
            int encodedSizeWithTag;
            int i = 0;
            int encodedSizeWithTag2 = locationInfo.geo != null ? LatLon.ADAPTER.encodedSizeWithTag(1, locationInfo.geo) : 0;
            if (locationInfo.ip_address != null) {
                encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(2, locationInfo.ip_address);
            } else {
                encodedSizeWithTag = 0;
            }
            encodedSizeWithTag2 += encodedSizeWithTag;
            if (locationInfo.location_str != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, locationInfo.location_str);
            }
            return (encodedSizeWithTag2 + i) + locationInfo.unknownFields().c();
        }

        public void encode(ProtoWriter protoWriter, LocationInfo locationInfo) {
            if (locationInfo.geo != null) {
                LatLon.ADAPTER.encodeWithTag(protoWriter, 1, locationInfo.geo);
            }
            if (locationInfo.ip_address != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, locationInfo.ip_address);
            }
            if (locationInfo.location_str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, locationInfo.location_str);
            }
            protoWriter.writeBytes(locationInfo.unknownFields());
        }

        public LocationInfo decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.geo((LatLon) LatLon.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.ip_address((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.location_str((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                }
                protoReader.endMessage(beginMessage);
                return builder.build();
            }
        }

        public LocationInfo redact(LocationInfo locationInfo) {
            Builder newBuilder = locationInfo.newBuilder();
            if (newBuilder.geo != null) {
                newBuilder.geo = (LatLon) LatLon.ADAPTER.redact(newBuilder.geo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public LocationInfo(LatLon latLon, String str, String str2) {
        this(latLon, str, str2, d.b);
    }

    public LocationInfo(LatLon latLon, String str, String str2, d dVar) {
        super(ADAPTER, dVar);
        this.geo = latLon;
        this.ip_address = str;
        this.location_str = str2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.geo = this.geo;
        builder.ip_address = this.ip_address;
        builder.location_str = this.location_str;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationInfo)) {
            return false;
        }
        LocationInfo locationInfo = (LocationInfo) obj;
        if (unknownFields().equals(locationInfo.unknownFields()) && Internal.equals(this.geo, locationInfo.geo) && Internal.equals(this.ip_address, locationInfo.ip_address) && Internal.equals(this.location_str, locationInfo.location_str)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = ((this.geo != null ? this.geo.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37;
        if (this.ip_address != null) {
            i2 = this.ip_address.hashCode();
        } else {
            i2 = 0;
        }
        i2 = (i2 + hashCode) * 37;
        if (this.location_str != null) {
            i = this.location_str.hashCode();
        }
        i2 += i;
        this.hashCode = i2;
        return i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.geo != null) {
            stringBuilder.append(", geo=").append(this.geo);
        }
        if (this.ip_address != null) {
            stringBuilder.append(", ip_address=").append(this.ip_address);
        }
        if (this.location_str != null) {
            stringBuilder.append(", location_str=").append(this.location_str);
        }
        return stringBuilder.replace(0, 2, "LocationInfo{").append('}').toString();
    }
}
