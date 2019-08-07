package com.github.pozo.mnb.qrcode.serialize;

public interface FieldDeserializer<T> {

    T deserialize(String field);
}
