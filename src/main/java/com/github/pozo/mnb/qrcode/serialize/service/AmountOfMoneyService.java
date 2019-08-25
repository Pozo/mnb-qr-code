package com.github.pozo.mnb.qrcode.serialize.service;

import com.github.pozo.mnb.qrcode.serialize.FieldService;
import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.Optional;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Optional.of;

public class AmountOfMoneyService implements FieldService<Integer, String> {

    private static final String HUF = "HUF";

    AmountOfMoneyService() {
    }

    @Override
    public Integer deserialize(Supplier<String> function) {
        String rawAmount = function.get();
        rawAmount = rawAmount.replaceAll("[^\\d.]", "");

        if (rawAmount.isEmpty()) {
            return null;
        } else {
            return Integer.parseInt(rawAmount);
        }

    }

    @Override
    public String serialize(Supplier<Integer> function) {
        Integer amount = function.get();
        if (amount != null) {
            return amount + HUF;
        } else {
            return "";
        }

    }

    @Override
    public Optional<String> validate(QrCodeFields field, Supplier<Integer> function) {
        checkNotNull(function);

        final Integer value = function.get();
        if (field.isMandatory() && value == null) {
            return of("Field cant be empty or null!");
        }
        if (field.isFixedLength() && (value + HUF).length() > field.getLength()) {
            return of(String.format("Field cant be longer than %s!", field.getLength()));
        }
        return Optional.empty();
    }
}
