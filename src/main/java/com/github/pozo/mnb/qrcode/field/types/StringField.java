package com.github.pozo.mnb.qrcode.field.types;

import com.github.pozo.mnb.qrcode.field.FieldSerializer;
import com.github.pozo.mnb.qrcode.field.FieldValidator;
import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.Optional;

import static java.util.Optional.of;

public class StringField implements FieldValidator<String>, FieldSerializer<String, String> {

    @Override
    public Optional<String> validate(QrCodeFields field, String value) {
        if (field.isMandatory() && (value == null || value.isEmpty())) {
            return of(String.format("Field '%s' cant be empty or null!. The actual value is '%s'", field.name(), value));
        }
        if (value != null && (field.isFixedLength() && value.length() > field.getLength())) {
            return of(String.format("Field '%s' can't be longer than '%s'. The actual size is '%s'", field.name(), field.getLength(), value.length()));
        }
        return Optional.empty();
    }

    @Override
    public String serialize(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}
