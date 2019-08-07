package com.github.pozo.mnb.qrcode.serialize.fields;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.serialize.FieldSerializer;

public class CustomerIdentifierSerializer implements FieldSerializer {
    @Override
    public String serialize(MnbQrCode from) {
        return from.getCustomerIdentifier().orElse(EMPTY);
    }
}
