package com.github.pozo.mnb.qrcode.deserialize;

import com.github.pozo.mnb.qrcode.specification.QrCodeFields;

public class MnbQrCodeRawBuilder {

    private String identificationCode;

    private String versionNumber;

    private String characterSet;

    private String payerOrBeneficiaryBIC;

    private String payerOrBeneficiaryName;

    private String payerOrBeneficiaryIBAN;

    private String amountOfMoney;

    private String validity;

    private String paymentSituationIdentifier;

    private String statement;

    private String commercialUnitIdentifier;

    private String merchantDeviceIdentifier;

    private String invoiceOrReceiptIdentifier;

    private String customerIdentifier;

    private String beneficiaryInternalTransactionIdentifier;

    private String beneficiaryOrRegularCustomerIdentifier;

    private String verificationNumberOfNAV;

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    public void setPayerOrBeneficiaryBIC(String payerOrBeneficiaryBIC) {
        this.payerOrBeneficiaryBIC = payerOrBeneficiaryBIC;
    }

    public void setPayerOrBeneficiaryName(String payerOrBeneficiaryName) {
        this.payerOrBeneficiaryName = payerOrBeneficiaryName;
    }

    public void setPayerOrBeneficiaryIBAN(String payerOrBeneficiaryIBAN) {
        this.payerOrBeneficiaryIBAN = payerOrBeneficiaryIBAN;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public void setPaymentSituationIdentifier(String paymentSituationIdentifier) {
        this.paymentSituationIdentifier = paymentSituationIdentifier;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void setCommercialUnitIdentifier(String commercialUnitIdentifier) {
        this.commercialUnitIdentifier = commercialUnitIdentifier;
    }

    public void setMerchantDeviceIdentifier(String merchantDeviceIdentifier) {
        this.merchantDeviceIdentifier = merchantDeviceIdentifier;
    }

    public void setInvoiceOrReceiptIdentifier(String invoiceOrReceiptIdentifier) {
        this.invoiceOrReceiptIdentifier = invoiceOrReceiptIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

    public void setBeneficiaryInternalTransactionIdentifier(String beneficiaryInternalTransactionIdentifier) {
        this.beneficiaryInternalTransactionIdentifier = beneficiaryInternalTransactionIdentifier;
    }

    public void setBeneficiaryOrRegularCustomerIdentifier(String beneficiaryOrRegularCustomerIdentifier) {
        this.beneficiaryOrRegularCustomerIdentifier = beneficiaryOrRegularCustomerIdentifier;
    }

    public void setVerificationNumberOfNAV(String verificationNumberOfNAV) {
        this.verificationNumberOfNAV = verificationNumberOfNAV;
    }

    public MnbQrCodeRaw createMnbQrCode() {
        return new MnbQrCodeRaw(
                identificationCode,
                versionNumber,
                characterSet,
                payerOrBeneficiaryBIC,
                payerOrBeneficiaryName,
                payerOrBeneficiaryIBAN,
                amountOfMoney,
                validity,
                paymentSituationIdentifier,
                statement,
                commercialUnitIdentifier,
                merchantDeviceIdentifier,
                invoiceOrReceiptIdentifier,
                customerIdentifier,
                beneficiaryInternalTransactionIdentifier,
                beneficiaryOrRegularCustomerIdentifier,
                verificationNumberOfNAV
        );
    }

    public void set(QrCodeFields field, String fieldValue) {
        switch (field) {
            case IDENTIFICATION_CODE:
                setIdentificationCode(fieldValue);
                break;
            case VERSION_NUMBER:
                setVersionNumber(fieldValue);
                break;
            case CHARACTER_SET:
                setCharacterSet(fieldValue);
                break;
            case PAYER_OR_BENEFICIARY_BIC:
                setPayerOrBeneficiaryBIC(fieldValue);
                break;
            case PAYER_OR_BENEFICIARY_NAME:
                setPayerOrBeneficiaryName(fieldValue);
                break;
            case PAYER_OR_BENEFICIARY_IBAN:
                setPayerOrBeneficiaryIBAN(fieldValue);
                break;
            case AMOUNT_OF_MONEY:
                setAmountOfMoney(fieldValue);
                break;
            case VALIDITY:
                setValidity(fieldValue);
                break;
            case PAYMENT_SITUATION_IDENTIFIER:
                setPaymentSituationIdentifier(fieldValue);
                break;
            case STATEMENT:
                setStatement(fieldValue);
                break;
            case COMMERCIAL_UNIT_IDENTIFIER:
                setCommercialUnitIdentifier(fieldValue);
                break;
            case MERCHANT_DEVICE_IDENTIFIER:
                setMerchantDeviceIdentifier(fieldValue);
                break;
            case INVOICE_OR_RECEIPT_IDENTIFIER:
                setInvoiceOrReceiptIdentifier(fieldValue);
                break;
            case CUSTOMER_IDENTIFIER:
                setCustomerIdentifier(fieldValue);
                break;
            case BENEFICIARY_INTERNAL_TRANSACTION_IDENTIFIER:
                setBeneficiaryInternalTransactionIdentifier(fieldValue);
                break;
            case BENEFICIARY_OR_REGULAR_CUSTOMER_IDENTIFIER:
                setBeneficiaryOrRegularCustomerIdentifier(fieldValue);
                break;
            case VERIFICATION_NUMBER_OF_NAV:
                setVerificationNumberOfNAV(fieldValue);
                break;
            default:
                throw new IllegalArgumentException(String.format("There is no target field for parsed field '%s' with value '%s'", field, fieldValue));
        }
    }
}