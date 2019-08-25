package com.github.pozo.mnb.qrcode.serialize;

import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.Optional;
import java.util.function.Supplier;

interface ValidatorService<FROM> {

    Optional<String> validate(QrCodeFields field, Supplier<FROM> function);

}
