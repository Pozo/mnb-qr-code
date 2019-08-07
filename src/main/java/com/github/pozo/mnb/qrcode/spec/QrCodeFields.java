package com.github.pozo.mnb.qrcode.spec;

public enum QrCodeFields {

    IDENTIFICATION_CODE(3, true, true),
    VERSION_NUMBER(3, true, true),
    CHARACTER_SET(1, true, true),
    PAYER_OR_BENEFICIARY_BIC(11, true, true),
    PAYER_OR_BENEFICIARY_NAME(70, true, false),
    PAYER_OR_BENEFICIARY_IBAN(28, true, true),
    AMOUNT_OF_MONEY(15, false, false),
    VALIDITY(16, true, true),
    PAYMENT_SITUATION_IDENTIFIER(4, false, true),
    STATEMENT(70, false, false),
    COMMERCIAL_UNIT_IDENTIFIER(35, false, false),
    MERCHANT_DEVICE_IDENTIFIER(35, false, false),
    INVOICE_OR_RECEIPT_IDENTIFIER(35, false, false),
    CUSTOMER_IDENTIFIER(35, false, false),
    BENEFICIARY_INTERNAL_TRANSACTION_IDENTIFIER(35, false, false),
    BENEFICIARY_OR_REGULAR_CUSTOMER_IDENTIFIER(35, false, false),
    VERIFICATION_NUMBER_OF_NAV(35, false, false);

    private final int length;

    private final boolean isMandatory;

    private final boolean isFixedLength;

    QrCodeFields(int length, boolean isMandatory, boolean isFixedLength) {
        this.length = length;
        this.isMandatory = isMandatory;
        this.isFixedLength = isFixedLength;
    }

    public int getLength() {
        return length;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public boolean isFixedLength() {
        return isFixedLength;
    }
}
