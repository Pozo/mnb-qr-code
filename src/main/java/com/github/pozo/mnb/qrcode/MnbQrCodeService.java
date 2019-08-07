package com.github.pozo.mnb.qrcode;

import com.github.pozo.mnb.qrcode.deserialize.MnbQrCodeRawBuilder;
import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.serialize.DefaultFieldSerializerService;
import com.github.pozo.mnb.qrcode.serialize.FieldSerializerService;
import com.github.pozo.mnb.qrcode.spec.QrCodeFields;
import com.github.pozo.mnb.qrcode.validate.DefaultFieldValidatorService;
import com.github.pozo.mnb.qrcode.validate.FieldValidatorService;

import static com.google.common.base.Preconditions.checkNotNull;

public class MnbQrCodeService {

    private static final String FIELD_SEPARATOR = "\n";

    private final FieldSerializerService serializer = new DefaultFieldSerializerService();

//    private final FieldDeserializerService deserializer = new DefaultFieldDeserializerService();

//    private final EnumMap<QrCodeFields, Function<>> deserializer = new EnumMap<>(QrCodeFields.class);

    private final FieldValidatorService validator = new DefaultFieldValidatorService();

    public boolean validate(MnbQrCode mnbQrCode) {
        checkNotNull(mnbQrCode);

        for (QrCodeFields field : QrCodeFields.values()) {
            boolean isValid = validator.validate(mnbQrCode, field);

            if (!isValid) {
                return false;
            }
        }
        return true;
    }

    public String serialize(MnbQrCode mnbQrCode) {
        checkNotNull(mnbQrCode);

        final StringBuilder qrCode = new StringBuilder();

        for (QrCodeFields field : QrCodeFields.values()) {
            String serializedField = serializer.serialize(mnbQrCode, field);
            qrCode.append(serializedField);
            qrCode.append(FIELD_SEPARATOR);
        }

        return qrCode.toString();
    }

    public boolean validate(String mnbQrCode) {
        checkNotNull(mnbQrCode);

        final String[] parsedFields = mnbQrCode.split(FIELD_SEPARATOR);
        return parsedFields.length == QrCodeFields.values().length;
    }

    public MnbQrCode deserialize(String mnbQrCode) {
        checkNotNull(mnbQrCode);

        final String[] parsedFields = mnbQrCode.split(FIELD_SEPARATOR, -1);
        final MnbQrCodeRawBuilder builder = new MnbQrCodeRawBuilder();

        for (QrCodeFields field : QrCodeFields.values()) {
            builder.set(field, parsedFields[field.ordinal()]);
        }

        System.out.println("builder = " + builder.createMnbQrCode());
        return null;
    }
}
