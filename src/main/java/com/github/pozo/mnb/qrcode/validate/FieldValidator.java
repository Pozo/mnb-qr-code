package com.github.pozo.mnb.qrcode.validate;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;

public interface FieldValidator {

    boolean isValid(MnbQrCode qrCode);
}
