package com.github.pozo.mnb.qrcode.serialize;

import com.github.pozo.mnb.qrcode.serialize.fields.AmountOfMoneyService;
import com.github.pozo.mnb.qrcode.serialize.fields.IdentificationCodeService;
import com.github.pozo.mnb.qrcode.serialize.fields.StringFieldService;
import com.github.pozo.mnb.qrcode.spec.QrCodeFields;

import java.util.EnumMap;

public class MnbQrCodeSerializers {

    private static final IdentificationCodeService IDENTIFICATION_CODE_SERVICE = new IdentificationCodeService();

    private static final StringFieldService STRING_FIELD_SERVICE = new StringFieldService();

    private final static AmountOfMoneyService AMOUNT_OF_MONEY_SERVICE = new AmountOfMoneyService();

    private final EnumMap<QrCodeFields, FieldService<?, ?>> services = new EnumMap<>(QrCodeFields.class);

    public MnbQrCodeSerializers() {
        services.put(QrCodeFields.IDENTIFICATION_CODE, IDENTIFICATION_CODE_SERVICE);
        services.put(QrCodeFields.VERSION_NUMBER, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.CHARACTER_SET, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.PAYER_OR_BENEFICIARY_BIC, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.PAYER_OR_BENEFICIARY_NAME, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.PAYER_OR_BENEFICIARY_IBAN, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.AMOUNT_OF_MONEY, AMOUNT_OF_MONEY_SERVICE);
        services.put(QrCodeFields.VALIDITY, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.PAYMENT_SITUATION_IDENTIFIER, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.STATEMENT, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.COMMERCIAL_UNIT_IDENTIFIER, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.MERCHANT_DEVICE_IDENTIFIER, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.INVOICE_OR_RECEIPT_IDENTIFIER, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.CUSTOMER_IDENTIFIER, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.BENEFICIARY_INTERNAL_TRANSACTION_IDENTIFIER, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.BENEFICIARY_OR_REGULAR_CUSTOMER_IDENTIFIER, STRING_FIELD_SERVICE);
        services.put(QrCodeFields.VERIFICATION_NUMBER_OF_NAV, STRING_FIELD_SERVICE);
    }

    public FieldService getServiceFor(QrCodeFields codeField) {
        return services.get(codeField);
    }
}
