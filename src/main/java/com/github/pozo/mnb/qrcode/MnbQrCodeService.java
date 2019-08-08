package com.github.pozo.mnb.qrcode;

import com.github.pozo.mnb.qrcode.deserialize.MnbQrCodeRawBuilder;
import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.serialize.FieldProviderService;
import com.github.pozo.mnb.qrcode.serialize.FieldService;
import com.github.pozo.mnb.qrcode.serialize.MnbQrCodeSerializers;
import com.github.pozo.mnb.qrcode.spec.QrCodeFields;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;

public class MnbQrCodeService {

    private static final String FIELD_SEPARATOR = "\n";

    private final MnbQrCodeSerializers serializers = new MnbQrCodeSerializers();

    private final FieldProviderService fieldProviders = new FieldProviderService();

    public String serialize(MnbQrCode mnbQrCode) {
        checkNotNull(mnbQrCode, "The 'mnbQrCode' parameter can't be null!");

        final StringBuilder qrCode = new StringBuilder();

        for (QrCodeFields value : QrCodeFields.values()) {
            final FieldService fieldService = serializers.getServiceFor(value);

            qrCode.append(fieldService.serialize(() -> fieldProviders.getFieldProviderFor(value).apply(mnbQrCode)));
            qrCode.append(FIELD_SEPARATOR);
        }

        return qrCode.toString();
    }

    public String deserialize(String mnbQrCode) {
        checkNotNull(mnbQrCode, "The 'mnbQrCode' parameter can't be null!");

        MnbQrCodeRawBuilder qrCode = new MnbQrCodeRawBuilder();
        String[] meh = mnbQrCode.split(FIELD_SEPARATOR, -1);

        for (QrCodeFields value : QrCodeFields.values()) {
            final FieldService fieldService = serializers.getServiceFor(value);

            // TODO toString
            qrCode.set(value, fieldService.deserialize(() -> meh[value.ordinal()]) + "");
        }

        return qrCode.toString();
    }

    public boolean validate(MnbQrCode mnbQrCode) {
        checkNotNull(mnbQrCode, "The 'mnbQrCode' parameter can't be null!");

        for (QrCodeFields value : QrCodeFields.values()) {
            final FieldService fieldService = serializers.getServiceFor(value);
            Function<MnbQrCode, ?> fieldProviderFor = fieldProviders.getFieldProviderFor(value);
            Supplier supplier = () -> fieldProviderFor.apply(mnbQrCode);
            final Optional isThereAnError = fieldService.validate(value, supplier);

            if (isThereAnError.isPresent()) {
                return false;
            }
        }
        return true;
    }

}
