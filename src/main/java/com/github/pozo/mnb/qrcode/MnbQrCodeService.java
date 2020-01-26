package com.github.pozo.mnb.qrcode;

import com.github.pozo.mnb.qrcode.deserialize.MnbQrCodeRaw;
import com.github.pozo.mnb.qrcode.deserialize.MnbQrCodeRawBuilder;
import com.github.pozo.mnb.qrcode.deserialize.map.MnbQrCodeRawMapper;
import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.field.FieldService;
import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class MnbQrCodeService implements MnbQrCodeApi {

    private static final String FIELD_SEPARATOR = "\n";

    private final FieldService fieldService = new FieldService();

    private final MnbQrCodeRawMapper mnbQrCodeRawMapper = new MnbQrCodeRawMapper();

    public String serialize(MnbQrCode mnbQrCode) {
        checkNotNull(mnbQrCode, "The 'mnbQrCode' parameter can't be null!");

        final StringBuilder qrCode = new StringBuilder();

        for (QrCodeFields field : QrCodeFields.values()) {
            final String serialize = fieldService.serialize(mnbQrCode, field);
            qrCode.append(serialize);
            qrCode.append(FIELD_SEPARATOR);
        }

        return qrCode.toString();
    }

    public MnbQrCode deserialize(String mnbQrCode) {
        checkNotNull(mnbQrCode, "The 'mnbQrCode' parameter can't be null!");
        checkArgument(!mnbQrCode.isEmpty(), "The 'mnbQrCode' parameter can't be empty!");

        final MnbQrCodeRawBuilder qrCode = new MnbQrCodeRawBuilder();
        final String[] fields = mnbQrCode.split(FIELD_SEPARATOR, -1);

        for (QrCodeFields field : QrCodeFields.values()) {
            final String fieldValue = fields[field.ordinal()];
            if (fieldValue == null || fieldValue.isEmpty()) {
                qrCode.set(field, null);
            } else {
                qrCode.set(field, fieldValue);
            }

        }

        final MnbQrCodeRaw rawMnbQrCode = qrCode.createMnbQrCode();

        return mnbQrCodeRawMapper.map(rawMnbQrCode);
    }

    public boolean validate(MnbQrCode mnbQrCode) {
        checkNotNull(mnbQrCode, "The 'mnbQrCode' parameter can't be null!");

        final List<String> listOfErrors = validateAnRetrieveErrors(mnbQrCode);

        return listOfErrors.isEmpty();
    }

    public List<String> validateAnRetrieveErrors(MnbQrCode mnbQrCode) {
        checkNotNull(mnbQrCode, "The 'mnbQrCode' parameter can't be null!");

        final ArrayList<String> listOfErrors = new ArrayList<>();

        for (QrCodeFields field : QrCodeFields.values()) {
            fieldService.validate(mnbQrCode, field).ifPresent(listOfErrors::add);
        }

        return Collections.unmodifiableList(listOfErrors);
    }

}
