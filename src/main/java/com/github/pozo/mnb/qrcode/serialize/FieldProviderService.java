package com.github.pozo.mnb.qrcode.serialize;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.spec.QrCodeFields;

import java.util.EnumMap;
import java.util.Optional;
import java.util.function.Function;

public class FieldProviderService {

    private final EnumMap<QrCodeFields, Function<MnbQrCode, ?>> fieldProviders = new EnumMap<>(QrCodeFields.class);

    private final Function<Optional<?>, ?> getOrNull = (optional) -> optional.orElse(null);

    public FieldProviderService() {
        fieldProviders.put(QrCodeFields.IDENTIFICATION_CODE, MnbQrCode::getIdentificationCode);
        fieldProviders.put(QrCodeFields.VERSION_NUMBER, MnbQrCode::getVersionNumber);
        fieldProviders.put(QrCodeFields.CHARACTER_SET, MnbQrCode::getCharacterSet);
        fieldProviders.put(QrCodeFields.PAYER_OR_BENEFICIARY_BIC, MnbQrCode::getPayerOrBeneficiaryBIC);
        fieldProviders.put(QrCodeFields.PAYER_OR_BENEFICIARY_NAME, MnbQrCode::getPayerOrBeneficiaryName);
        fieldProviders.put(QrCodeFields.PAYER_OR_BENEFICIARY_IBAN, MnbQrCode::getPayerOrBeneficiaryIBAN);
        fieldProviders.put(QrCodeFields.AMOUNT_OF_MONEY, (qrCode) -> getOrNull.apply(qrCode.getAmountOfMoney()));
        fieldProviders.put(QrCodeFields.VALIDITY, MnbQrCode::getValidity);
        fieldProviders.put(QrCodeFields.PAYMENT_SITUATION_IDENTIFIER, (qrCode) -> getOrNull.apply(qrCode.getPaymentSituationIdentifier()));
        fieldProviders.put(QrCodeFields.STATEMENT, (qrCode) -> getOrNull.apply(qrCode.getStatement()));
        fieldProviders.put(QrCodeFields.COMMERCIAL_UNIT_IDENTIFIER, (qrCode) -> getOrNull.apply(qrCode.getCommercialUnitIdentifier()));
        fieldProviders.put(QrCodeFields.MERCHANT_DEVICE_IDENTIFIER, (qrCode) -> getOrNull.apply(qrCode.getMerchantDeviceIdentifier()));
        fieldProviders.put(QrCodeFields.INVOICE_OR_RECEIPT_IDENTIFIER, (qrCode) -> getOrNull.apply(qrCode.getInvoiceOrReceiptIdentifier()));
        fieldProviders.put(QrCodeFields.CUSTOMER_IDENTIFIER, (qrCode) -> getOrNull.apply(qrCode.getCustomerIdentifier()));
        fieldProviders.put(QrCodeFields.BENEFICIARY_INTERNAL_TRANSACTION_IDENTIFIER, (qrCode) -> getOrNull.apply(qrCode.getBeneficiaryInternalTransactionIdentifier()));
        fieldProviders.put(QrCodeFields.BENEFICIARY_OR_REGULAR_CUSTOMER_IDENTIFIER, (qrCode) -> getOrNull.apply(qrCode.getBeneficiaryOrRegularCustomerIdentifier()));
        fieldProviders.put(QrCodeFields.VERIFICATION_NUMBER_OF_NAV, (qrCode) -> getOrNull.apply(qrCode.getVerificationNumberOfNAV()));
    }

    public Function<MnbQrCode, ?> getFieldProviderFor(QrCodeFields codeField) {
        return fieldProviders.get(codeField);
    }
}
