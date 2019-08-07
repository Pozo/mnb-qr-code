package com.github.pozo.mnb.qrcode.serialize.fields;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.serialize.FieldDeserializer;
import com.github.pozo.mnb.qrcode.serialize.FieldSerializer;

import java.util.Optional;

public class AmountOfMoneySerializer implements FieldSerializer, FieldDeserializer<Integer> {
    @Override
    public String serialize(MnbQrCode from) {
        final Optional<Integer> amountOfMoney = from.getAmountOfMoney();
        return amountOfMoney.map(integer -> integer + "HUF").orElse(EMPTY);
    }

    @Override
    public Integer deserialize(String field) {
        return null;
    }
}
