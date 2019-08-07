package com.github.pozo.mnb.qrcode.serialize.fields;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.serialize.FieldSerializer;

public class MerchantDeviceIdentifierSerializer implements FieldSerializer {
    @Override
    public String serialize(MnbQrCode from) {
        return from.getMerchantDeviceIdentifier().orElse(EMPTY);
    }
}
