package com.github.pozo.mnb.qrcode.field;

public interface FieldSerializer<FROM, TO> {

    TO serialize(FROM from);

}
