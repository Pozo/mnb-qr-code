package com.github.pozo.mnb.qrcode.validate;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.spec.QrCodeFields;

public interface FieldValidatorService {

    void setValidator(
            QrCodeFields field,
            FieldValidator fieldValidator
    );

    boolean validate(MnbQrCode mnbQrCode, QrCodeFields qrCode);
}
