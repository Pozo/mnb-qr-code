package com.github.pozo.mnb.qrcode.domain;

public class MnbQrCodeBuilderHCTWithDefaultValues extends MnbQrCodeBuilder {

    public MnbQrCodeBuilderHCTWithDefaultValues(String payerOrBeneficiaryBIC, String payerOrBeneficiaryName, String payerOrBeneficiaryIBAN, String validity) {
        super(
                IdentificationCode.HCT,
                MnbQrCodeValues.VERSION_NUMBER,
                MnbQrCodeValues.CHARACTER_SET,
                payerOrBeneficiaryBIC,
                payerOrBeneficiaryName,
                payerOrBeneficiaryIBAN,
                validity
        );
    }

}
