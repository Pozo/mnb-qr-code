package com.github.pozo.mnb.qrcode.field;

import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.Optional;

public interface FieldValidator<FROM> {

    Optional<String> validate(QrCodeFields field, FROM from);

}
