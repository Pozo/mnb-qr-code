package com.github.pozo.mnb.qrcode.field.types;

import com.github.pozo.mnb.qrcode.field.FieldSerializer;
import com.github.pozo.mnb.qrcode.field.FieldValidator;
import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.Optional;

import static java.util.Optional.of;

public class AmountOfMoneyField implements FieldValidator<Integer>, FieldSerializer<Integer, String> {

    private static final String HUF = "HUF";

    @Override
    public String serialize(Integer amount) {
        if (amount != null) {
            return amount + HUF;
        } else {
            return "";
        }

    }

    @Override
    public Optional<String> validate(QrCodeFields field, Integer value) {
        if (field.isMandatory() && value == null) {
            return of(String.format("Field '%s' cant be null!", field.name()));
        }
        final String valueWithPostfix = value + HUF;

        if (field.isFixedLength() && valueWithPostfix.length() > field.getLength()) {
            return of(
                    String.format(
                            "Field '%s' can't be longer than '%s' with the postfix '%s'. The actual size is '%s'",
                            field.name(),
                            field.getLength(),
                            HUF,
                            valueWithPostfix.length()
                    )
            );
        }
        return Optional.empty();
    }
}
