package com.github.pozo.mnb.qrcode.field;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.field.types.AmountOfMoneyField;
import com.github.pozo.mnb.qrcode.field.types.IdentificationCodeField;
import com.github.pozo.mnb.qrcode.field.types.StringField;
import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

import java.util.Optional;

public class FieldService {

    private static final String EMPTY = "";

    private final IdentificationCodeField identificationCodeService = new IdentificationCodeField();

    private final StringField stringField = new StringField();

    private final AmountOfMoneyField amountOfMoneyService = new AmountOfMoneyField();

    public String serialize(MnbQrCode mnbQrCode, QrCodeFields field) {
        switch (field) {
            case IDENTIFICATION_CODE:
                return identificationCodeService.serialize(mnbQrCode.getIdentificationCode());
            case VERSION_NUMBER:
                return stringField.serialize(mnbQrCode.getVersionNumber());
            case CHARACTER_SET:
                return stringField.serialize(mnbQrCode.getCharacterSet());
            case PAYER_OR_BENEFICIARY_BIC:
                return stringField.serialize(mnbQrCode.getPayerOrBeneficiaryBIC());
            case PAYER_OR_BENEFICIARY_NAME:
                return stringField.serialize(mnbQrCode.getPayerOrBeneficiaryName());
            case PAYER_OR_BENEFICIARY_IBAN:
                return stringField.serialize(mnbQrCode.getPayerOrBeneficiaryIBAN());
            case AMOUNT_OF_MONEY:
                return mnbQrCode.getAmountOfMoney().map(amountOfMoneyService::serialize).orElse(EMPTY);
            case VALIDITY:
                return stringField.serialize(mnbQrCode.getValidity());
            case PAYMENT_SITUATION_IDENTIFIER:
                return mnbQrCode.getPaymentSituationIdentifier().map(stringField::serialize).orElse(EMPTY);
            case STATEMENT:
                return mnbQrCode.getStatement().map(stringField::serialize).orElse(EMPTY);
            case COMMERCIAL_UNIT_IDENTIFIER:
                return mnbQrCode.getCommercialUnitIdentifier().map(stringField::serialize).orElse(EMPTY);
            case MERCHANT_DEVICE_IDENTIFIER:
                return mnbQrCode.getMerchantDeviceIdentifier().map(stringField::serialize).orElse(EMPTY);
            case INVOICE_OR_RECEIPT_IDENTIFIER:
                return mnbQrCode.getInvoiceOrReceiptIdentifier().map(stringField::serialize).orElse(EMPTY);
            case CUSTOMER_IDENTIFIER:
                return mnbQrCode.getCustomerIdentifier().map(stringField::serialize).orElse(EMPTY);
            case BENEFICIARY_INTERNAL_TRANSACTION_IDENTIFIER:
                return mnbQrCode.getBeneficiaryInternalTransactionIdentifier().map(stringField::serialize).orElse(EMPTY);
            case BENEFICIARY_OR_REGULAR_CUSTOMER_IDENTIFIER:
                return mnbQrCode.getBeneficiaryOrRegularCustomerIdentifier().map(stringField::serialize).orElse(EMPTY);
            case VERIFICATION_NUMBER_OF_NAV:
                return mnbQrCode.getVerificationNumberOfNAV().map(stringField::serialize).orElse(EMPTY);
            default:
                throw new IllegalArgumentException("Unknown field!");
        }
    }

    public Optional<String> validate(MnbQrCode mnbQrCode, QrCodeFields field) {
        switch (field) {
            case IDENTIFICATION_CODE:
                return identificationCodeService.validate(field, mnbQrCode.getIdentificationCode());
            case VERSION_NUMBER:
                return stringField.validate(field, mnbQrCode.getVersionNumber());
            case CHARACTER_SET:
                return stringField.validate(field, mnbQrCode.getCharacterSet());
            case PAYER_OR_BENEFICIARY_BIC:
                return stringField.validate(field, mnbQrCode.getPayerOrBeneficiaryBIC());
            case PAYER_OR_BENEFICIARY_NAME:
                return stringField.validate(field, mnbQrCode.getPayerOrBeneficiaryName());
            case PAYER_OR_BENEFICIARY_IBAN:
                return stringField.validate(field, mnbQrCode.getPayerOrBeneficiaryIBAN());
            case AMOUNT_OF_MONEY:
                return mnbQrCode.getAmountOfMoney().flatMap(it -> amountOfMoneyService.validate(field, it));
            case VALIDITY:
                return stringField.validate(field, mnbQrCode.getValidity());
            case PAYMENT_SITUATION_IDENTIFIER:
                return mnbQrCode.getPaymentSituationIdentifier().flatMap(it -> stringField.validate(field, it));
            case STATEMENT:
                return mnbQrCode.getStatement().flatMap(it -> stringField.validate(field, it));
            case COMMERCIAL_UNIT_IDENTIFIER:
                return mnbQrCode.getCommercialUnitIdentifier().flatMap(it -> stringField.validate(field, it));
            case MERCHANT_DEVICE_IDENTIFIER:
                return mnbQrCode.getMerchantDeviceIdentifier().flatMap(it -> stringField.validate(field, it));
            case INVOICE_OR_RECEIPT_IDENTIFIER:
                return mnbQrCode.getInvoiceOrReceiptIdentifier().flatMap(it -> stringField.validate(field, it));
            case CUSTOMER_IDENTIFIER:
                return mnbQrCode.getCustomerIdentifier().flatMap(it -> stringField.validate(field, it));
            case BENEFICIARY_INTERNAL_TRANSACTION_IDENTIFIER:
                return mnbQrCode.getBeneficiaryInternalTransactionIdentifier().flatMap(it -> stringField.validate(field, it));
            case BENEFICIARY_OR_REGULAR_CUSTOMER_IDENTIFIER:
                return mnbQrCode.getBeneficiaryOrRegularCustomerIdentifier().flatMap(it -> stringField.validate(field, it));
            case VERIFICATION_NUMBER_OF_NAV:
                return mnbQrCode.getVerificationNumberOfNAV().flatMap(it -> stringField.validate(field, it));
            default:
                throw new IllegalArgumentException("Unknown field!");
        }
    }
}
