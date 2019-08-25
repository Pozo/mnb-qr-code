package com.github.pozo.mnb.qrcode.domain;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class MnbQrCodeBuilder {

    private final IdentificationCode identificationCode;

    private final String versionNumber;

    private final String characterSet;

    private final String payerOrBeneficiaryBIC;

    private final String payerOrBeneficiaryName;

    private final String payerOrBeneficiaryIBAN;

    private Integer amountOfMoney;

    private final String validity;

    private String paymentSituationIdentifier;

    private String statement;

    private String commercialUnitIdentifier;

    private String merchantDeviceIdentifier;

    private String invoiceOrReceiptIdentifier;

    private String customerIdentifier;

    private String beneficiaryInternalTransactionIdentifier;

    private String beneficiaryOrRegularCustomerIdentifier;

    private String verificationNumberOfNAV;

    public MnbQrCodeBuilder(
            IdentificationCode identificationCode,
            String versionNumber,
            String characterSet,
            String payerOrBeneficiaryBIC,
            String payerOrBeneficiaryName,
            String payerOrBeneficiaryIBAN,
            String validity
    ) {
        checkNotNull(identificationCode, "The 'identificationCode' parameter can't be null!");
        checkNotNull(versionNumber, "The 'versionNumber' parameter can't be null!");
        checkState(!versionNumber.isEmpty(), "The 'versionNumber' parameter can't be empty!");
        checkNotNull(characterSet, "The 'characterSet' parameter can't be null!");
        checkState(!characterSet.isEmpty(), "The 'characterSet' parameter can't be empty!");
        checkNotNull(payerOrBeneficiaryBIC, "The 'payerOrBeneficiaryBIC' parameter can't be null!");
        checkState(!payerOrBeneficiaryBIC.isEmpty(), "The 'payerOrBeneficiaryBIC' parameter can't be empty!");
        checkNotNull(payerOrBeneficiaryName, "The 'payerOrBeneficiaryName' parameter can't be null!");
        checkState(!payerOrBeneficiaryName.isEmpty(), "The 'payerOrBeneficiaryName' parameter can't be empty!");
        checkNotNull(payerOrBeneficiaryIBAN, "The 'payerOrBeneficiaryIBAN' parameter can't be null!");
        checkState(!payerOrBeneficiaryIBAN.isEmpty(), "The 'payerOrBeneficiaryIBAN' parameter can't be empty!");
        checkNotNull(validity, "The 'validity' parameter can't be null!");
        checkState(!validity.isEmpty(), "The 'validity' parameter can't be empty!");

        this.identificationCode = identificationCode;
        this.versionNumber = versionNumber;
        this.characterSet = characterSet;
        this.payerOrBeneficiaryBIC = payerOrBeneficiaryBIC;
        this.payerOrBeneficiaryName = payerOrBeneficiaryName;
        this.payerOrBeneficiaryIBAN = payerOrBeneficiaryIBAN;
        this.validity = validity;
    }

    public MnbQrCodeBuilder setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
        return this;
    }

    public MnbQrCodeBuilder setPaymentSituationIdentifier(String paymentSituationIdentifier) {
        this.paymentSituationIdentifier = paymentSituationIdentifier;
        return this;
    }

    public MnbQrCodeBuilder setStatement(String statement) {
        this.statement = statement;
        return this;
    }

    public MnbQrCodeBuilder setCommercialUnitIdentifier(String commercialUnitIdentifier) {
        this.commercialUnitIdentifier = commercialUnitIdentifier;
        return this;
    }

    public MnbQrCodeBuilder setMerchantDeviceIdentifier(String merchantDeviceIdentifier) {
        this.merchantDeviceIdentifier = merchantDeviceIdentifier;
        return this;
    }

    public MnbQrCodeBuilder setInvoiceOrReceiptIdentifier(String invoiceOrReceiptIdentifier) {
        this.invoiceOrReceiptIdentifier = invoiceOrReceiptIdentifier;
        return this;
    }

    public MnbQrCodeBuilder setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
        return this;
    }

    public MnbQrCodeBuilder setBeneficiaryInternalTransactionIdentifier(String beneficiaryInternalTransactionIdentifier) {
        this.beneficiaryInternalTransactionIdentifier = beneficiaryInternalTransactionIdentifier;
        return this;
    }

    public MnbQrCodeBuilder setBeneficiaryOrRegularCustomerIdentifier(String beneficiaryOrRegularCustomerIdentifier) {
        this.beneficiaryOrRegularCustomerIdentifier = beneficiaryOrRegularCustomerIdentifier;
        return this;
    }

    public MnbQrCodeBuilder setVerificationNumberOfNAV(String verificationNumberOfNAV) {
        this.verificationNumberOfNAV = verificationNumberOfNAV;
        return this;
    }

    public MnbQrCode createMnbQrCode() {
        return new MnbQrCode(
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
}