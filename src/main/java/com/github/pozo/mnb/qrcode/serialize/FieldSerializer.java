package com.github.pozo.mnb.qrcode.serialize;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;

public interface FieldSerializer {

    String EMPTY = "";

    String serialize(MnbQrCode from);
}
