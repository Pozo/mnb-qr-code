package com.github.pozo.mnb.qrcode;

import com.github.pozo.mnb.qrcode.deserialize.MnbQrCodeRaw;
import com.github.pozo.mnb.qrcode.deserialize.MnbQrCodeRawBuilder;
import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.domain.MnbQrCodeFieldProvider;
import com.github.pozo.mnb.qrcode.map.MnbQrCodeRawMapper;
import com.github.pozo.mnb.qrcode.serialize.FieldService;
import com.github.pozo.mnb.qrcode.serialize.service.MnbQrCodeFieldServiceProvider;
import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.google.common.base.Preconditions.checkNotNull;

public class MnbQrCodeService {

    private static final String FIELD_SEPARATOR = "\n";

    private final MnbQrCodeFieldServiceProvider serializers = new MnbQrCodeFieldServiceProvider();

    private final MnbQrCodeFieldProvider mnbQrCodeFieldProviders = new MnbQrCodeFieldProvider();

    private final MnbQrCodeRawMapper mnbQrCodeRawMapper = new MnbQrCodeRawMapper();

    public String serialize(MnbQrCode mnbQrCode) {
        checkNotNull(mnbQrCode, "The 'mnbQrCode' parameter can't be null!");

        final StringBuilder qrCode = new StringBuilder();

        for (QrCodeFields value : QrCodeFields.values()) {
            final FieldService fieldService = serializers.getServiceFor(value);

            qrCode.append(fieldService.serialize(() -> mnbQrCodeFieldProviders.getFieldProviderFor(value).apply(mnbQrCode)));
            qrCode.append(FIELD_SEPARATOR);
        }

        return qrCode.toString();
    }

    public MnbQrCode deserialize(String mnbQrCode) {
        checkNotNull(mnbQrCode, "The 'mnbQrCode' parameter can't be null!");

        final MnbQrCodeRawBuilder qrCode = new MnbQrCodeRawBuilder();
        final String[] fields = mnbQrCode.split(FIELD_SEPARATOR, -1);

        for (QrCodeFields field : QrCodeFields.values()) {
            final FieldService fieldService = serializers.getServiceFor(field);
            final String fieldValue = Optional.of(fieldService)
                    .map(it -> it.deserialize(() -> fields[field.ordinal()]))
                    .map(Object::toString)
                    .orElse(null);

            qrCode.set(field, fieldValue);
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

        for (QrCodeFields value : QrCodeFields.values()) {
            final FieldService fieldService = serializers.getServiceFor(value);
            final Function<MnbQrCode, ?> fieldProviderFor = mnbQrCodeFieldProviders.getFieldProviderFor(value);
            final Supplier supplier = () -> fieldProviderFor.apply(mnbQrCode);
            final Optional<String> error = fieldService.validate(value, supplier);

            error.ifPresent(listOfErrors::add);
        }

        return Collections.unmodifiableList(listOfErrors);
    }

}
