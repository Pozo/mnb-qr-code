package com.github.pozo.mnb.qrcode.field.types;

import com.github.pozo.mnb.qrcode.domain.IdentificationCode;
import com.github.pozo.mnb.qrcode.field.FieldSerializer;
import com.github.pozo.mnb.qrcode.field.FieldValidator;
import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.Optional;

import static java.util.Optional.of;

public class IdentificationCodeField implements FieldValidator<IdentificationCode>, FieldSerializer<IdentificationCode, String> {

    @Override
    public String serialize(IdentificationCode identificationCode) {
        if (identificationCode != null) {
            return identificationCode.toString();
        } else {
            return null;
        }
    }


    @Override
    public Optional<String> validate(QrCodeFields field, IdentificationCode value) {
        if (field.isMandatory() && value == null) {
            return of(String.format("Field '%s' cant be null!", field.name()));
        }
        if (field.isFixedLength() && value.toString().length() > field.getLength()) {
            return of(String.format("Field '%s' can't be longer than '%s'. The actual size is '%s'", field.name(), field.getLength(), value.toString().length()));
        }
        return Optional.empty();
    }
}
