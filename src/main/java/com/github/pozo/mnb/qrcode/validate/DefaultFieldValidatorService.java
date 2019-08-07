package com.github.pozo.mnb.qrcode.validate;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.spec.QrCodeFields;

import java.util.EnumMap;

public class DefaultFieldValidatorService implements FieldValidatorService {

    private final EnumMap<QrCodeFields, FieldValidator> validators = new EnumMap<>(QrCodeFields.class);

    @Override
    public void setValidator(QrCodeFields field, FieldValidator fieldValidator) {
        validators.put(field, fieldValidator);
    }

    @Override
    public boolean validate(MnbQrCode mnbQrCode, QrCodeFields field) {
        if (!validators.containsKey(field)) {
            throw new IllegalArgumentException(String.format("There is no validator found for '%s'", field));
        } else {
            return validators.get(field).isValid(mnbQrCode);
        }
    }
}
