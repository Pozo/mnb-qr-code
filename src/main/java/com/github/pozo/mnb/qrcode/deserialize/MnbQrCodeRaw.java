package com.github.pozo.mnb.qrcode.deserialize;

public class MnbQrCodeRaw {

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

    MnbQrCodeRaw(String identificationCode, String versionNumber, String characterSet, String payerOrBeneficiaryBIC, String payerOrBeneficiaryName, String payerOrBeneficiaryIBAN, String amountOfMoney, String validity, String paymentSituationIdentifier, String statement, String commercialUnitIdentifier, String merchantDeviceIdentifier, String invoiceOrReceiptIdentifier, String customerIdentifier, String beneficiaryInternalTransactionIdentifier, String beneficiaryOrRegularCustomerIdentifier, String verificationNumberOfNAV) {
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

    public String getIdentificationCode() {
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

    public String getAmountOfMoney() {
        return amountOfMoney;
    }

    public String getValidity() {
        return validity;
    }

    public String getPaymentSituationIdentifier() {
        return paymentSituationIdentifier;
    }

    public String getStatement() {
        return statement;
    }

    public String getCommercialUnitIdentifier() {
        return commercialUnitIdentifier;
    }

    public String getMerchantDeviceIdentifier() {
        return merchantDeviceIdentifier;
    }

    public String getInvoiceOrReceiptIdentifier() {
        return invoiceOrReceiptIdentifier;
    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public String getBeneficiaryInternalTransactionIdentifier() {
        return beneficiaryInternalTransactionIdentifier;
    }

    public String getBeneficiaryOrRegularCustomerIdentifier() {
        return beneficiaryOrRegularCustomerIdentifier;
    }

    public String getVerificationNumberOfNAV() {
        return verificationNumberOfNAV;
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
