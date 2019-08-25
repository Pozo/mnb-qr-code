package com.github.pozo.mnb.qrcode.serialize.service;

import com.github.pozo.mnb.qrcode.serialize.FieldService;
import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.Optional;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Optional.of;

public class StringFieldService implements FieldService<String, String> {

    StringFieldService() {
    }

    @Override
    public Optional<String> validate(QrCodeFields field, Supplier<String> function) {
        checkNotNull(function);

        final String value = function.get();
        if (field.isMandatory() && (value == null || value.isEmpty())) {
            return of(String.format("Field '%s' cant be empty or null!. The actual value is '%s'", field.name(), value));
        }
        if (value != null && (field.isFixedLength() && value.length() > field.getLength())) {
            return of(String.format("Field '%s' can't be longer than '%s'. The actual size is '%s'", field.name(), field.getLength(), value.length()));
        }
        return Optional.empty();
    }

    @Override
    public String deserialize(Supplier<String> function) {
        String value = function.get();
        if (value.isEmpty()) {
            return null;
        }
        return value;
    }

    @Override
    public String serialize(Supplier<String> function) {
        String value = function.get();
        if (value == null) {
            return "";
        }
        return value;
    }
}
