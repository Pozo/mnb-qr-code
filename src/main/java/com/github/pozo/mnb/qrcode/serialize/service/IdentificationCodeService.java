package com.github.pozo.mnb.qrcode.serialize.service;

import com.github.pozo.mnb.qrcode.domain.IdentificationCode;
import com.github.pozo.mnb.qrcode.serialize.FieldService;
import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.Optional;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Optional.of;

public class IdentificationCodeService implements FieldService<IdentificationCode, String> {

    IdentificationCodeService() {
    }

    @Override
    public IdentificationCode deserialize(Supplier<String> function) {
        IdentificationCode identificationCode = null;

        try {
            identificationCode = IdentificationCode.valueOf(function.get());
        } catch (IllegalArgumentException e) {

        }

        return identificationCode;
    }

    @Override
    public String serialize(Supplier<IdentificationCode> function) {
        IdentificationCode identificationCode = function.get();
        return identificationCode.toString();
    }


    @Override
    public Optional<String> validate(QrCodeFields field, Supplier<IdentificationCode> function) {
        checkNotNull(function);

        final IdentificationCode value = function.get();
        if (field.isMandatory() && value == null) {
            return of(String.format("Field '%s' cant be null!", field.name()));
        }
        if (field.isFixedLength() && value.toString().length() > field.getLength()) {
            return of(String.format("Field '%s' can't be longer than '%s'. The actual size is '%s'", field.name(), field.getLength(), value.toString().length()));
        }
        return Optional.empty();
    }
}
