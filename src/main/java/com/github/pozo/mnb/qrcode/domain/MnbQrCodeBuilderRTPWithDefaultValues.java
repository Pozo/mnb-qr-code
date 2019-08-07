package com.github.pozo.mnb.qrcode.domain;

public class MnbQrCodeBuilderRTPWithDefaultValues extends MnbQrCodeBuilder {

    public MnbQrCodeBuilderRTPWithDefaultValues(String payerOrBeneficiaryBIC, String payerOrBeneficiaryName, String payerOrBeneficiaryIBAN, String validity) {
        super(
                IdentificationCode.RTP,
                MnbQrCodeValues.VERSION_NUMBER,
                MnbQrCodeValues.CHARACTER_SET,
                payerOrBeneficiaryBIC,
                payerOrBeneficiaryName,
                payerOrBeneficiaryIBAN,
                validity
        );
    }
}
