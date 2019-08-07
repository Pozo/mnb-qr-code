package com.github.pozo.mnb.qrcode.domain;

import java.util.Optional;

import static java.util.Optional.ofNullable;

public class MnbQrCode {

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

    MnbQrCode(IdentificationCode identificationCode, String versionNumber, String characterSet, String payerOrBeneficiaryBIC, String payerOrBeneficiaryName, String payerOrBeneficiaryIBAN, Integer amountOfMoney, String validity, String paymentSituationIdentifier, String statement, String commercialUnitIdentifier, String merchantDeviceIdentifier, String invoiceOrReceiptIdentifier, String customerIdentifier, String beneficiaryInternalTransactionIdentifier, String beneficiaryOrRegularCustomerIdentifier, String verificationNumberOfNAV) {
        this.identificationCode = identificationCode;
        this.versionNumber = versionNumber;
        this.characterSet = characterSet;
        this.payerOrBeneficiaryBIC = payerOrBeneficiaryBIC;
        this.payerOrBeneficiaryName = payerOrBeneficiaryName;
        this.payerOrBeneficiaryIBAN = payerOrBeneficiaryIBAN;
        this.amountOfMoney = amountOfMoney;
        this.validity = validity;
        this.paymentSituationIdentifier = paymentSituationIdentifier;
        this.statement = statement;
        this.commercialUnitIdentifier = commercialUnitIdentifier;
        this.merchantDeviceIdentifier = merchantDeviceIdentifier;
        this.invoiceOrReceiptIdentifier = invoiceOrReceiptIdentifier;
        this.customerIdentifier = customerIdentifier;
        this.beneficiaryInternalTransactionIdentifier = beneficiaryInternalTransactionIdentifier;
        this.beneficiaryOrRegularCustomerIdentifier = beneficiaryOrRegularCustomerIdentifier;
        this.verificationNumberOfNAV = verificationNumberOfNAV;
    }

    public IdentificationCode getIdentificationCode() {
        return identificationCode;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public String getPayerOrBeneficiaryBIC() {
        return payerOrBeneficiaryBIC;
    }

    public String getPayerOrBeneficiaryName() {
        return payerOrBeneficiaryName;
    }

    public String getPayerOrBeneficiaryIBAN() {
        return payerOrBeneficiaryIBAN;
    }

    public Optional<Integer> getAmountOfMoney() {
        return ofNullable(amountOfMoney);
    }

    public String getValidity() {
        return validity;
    }

    public Optional<String> getPaymentSituationIdentifier() {
        return ofNullable(paymentSituationIdentifier);
    }

    public Optional<String> getStatement() {
        return ofNullable(statement);
    }

    public Optional<String> getCommercialUnitIdentifier() {
        return ofNullable(commercialUnitIdentifier);
    }

    public Optional<String> getMerchantDeviceIdentifier() {
        return ofNullable(merchantDeviceIdentifier);
    }

    public Optional<String> getInvoiceOrReceiptIdentifier() {
        return ofNullable(invoiceOrReceiptIdentifier);
    }

    public Optional<String> getCustomerIdentifier() {
        return ofNullable(customerIdentifier);
    }

    public Optional<String> getBeneficiaryInternalTransactionIdentifier() {
        return ofNullable(beneficiaryInternalTransactionIdentifier);
    }

    public Optional<String> getBeneficiaryOrRegularCustomerIdentifier() {
        return ofNullable(beneficiaryOrRegularCustomerIdentifier);
    }

    public Optional<String> getVerificationNumberOfNAV() {
        return ofNullable(verificationNumberOfNAV);
    }

    @Override
    public String toString() {
        return "MnbQrCode{" +
                "identificationCode=" + identificationCode +
                ", versionNumber='" + versionNumber + '\'' +
                ", characterSet='" + characterSet + '\'' +
                ", payerOrBeneficiaryBIC='" + payerOrBeneficiaryBIC + '\'' +
                ", payerOrBeneficiaryName='" + payerOrBeneficiaryName + '\'' +
                ", payerOrBeneficiaryIBAN='" + payerOrBeneficiaryIBAN + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                ", validity='" + validity + '\'' +
                ", paymentSituationIdentifier='" + paymentSituationIdentifier + '\'' +
                ", statement='" + statement + '\'' +
                ", commercialUnitIdentifier='" + commercialUnitIdentifier + '\'' +
                ", merchantDeviceIdentifier='" + merchantDeviceIdentifier + '\'' +
                ", invoiceOrReceiptIdentifier='" + invoiceOrReceiptIdentifier + '\'' +
                ", customerIdentifier='" + customerIdentifier + '\'' +
                ", beneficiaryInternalTransactionIdentifier='" + beneficiaryInternalTransactionIdentifier + '\'' +
                ", beneficiaryOrRegularCustomerIdentifier='" + beneficiaryOrRegularCustomerIdentifier + '\'' +
                ", verificationNumberOfNAV='" + verificationNumberOfNAV + '\'' +
                '}';
    }
}
