package com.github.pozo.mnb.qrcode.map;

import com.github.pozo.mnb.qrcode.deserialize.MnbQrCodeRaw;
import com.github.pozo.mnb.qrcode.domain.IdentificationCode;
import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.domain.MnbQrCodeBuilder;

import java.util.Optional;

public class MnbQrCodeRawMapper {

    public MnbQrCode map(MnbQrCodeRaw mnbQrCodeRaw) {
        IdentificationCode identificationCode = mapIdentificationCode(mnbQrCodeRaw);

        MnbQrCodeBuilder mnbQrCodeBuilder = new MnbQrCodeBuilder(
                identificationCode,
                mnbQrCodeRaw.getVersionNumber(),
                mnbQrCodeRaw.getCharacterSet(),
                mnbQrCodeRaw.getPayerOrBeneficiaryBIC(),
                mnbQrCodeRaw.getPayerOrBeneficiaryName(),
                mnbQrCodeRaw.getPayerOrBeneficiaryIBAN(),
                mnbQrCodeRaw.getValidity()
        );

        int amountOfMoney = mapAmountOfMoney(mnbQrCodeRaw);
        mnbQrCodeBuilder.setAmountOfMoney(amountOfMoney);
        mnbQrCodeBuilder.setPaymentSituationIdentifier(mnbQrCodeRaw.getPaymentSituationIdentifier());
        mnbQrCodeBuilder.setStatement(mnbQrCodeRaw.getStatement());
        mnbQrCodeBuilder.setCommercialUnitIdentifier(mnbQrCodeRaw.getCommercialUnitIdentifier());
        mnbQrCodeBuilder.setMerchantDeviceIdentifier(mnbQrCodeRaw.getMerchantDeviceIdentifier());
        mnbQrCodeBuilder.setInvoiceOrReceiptIdentifier(mnbQrCodeRaw.getInvoiceOrReceiptIdentifier());
        mnbQrCodeBuilder.setCustomerIdentifier(mnbQrCodeRaw.getCustomerIdentifier());
        mnbQrCodeBuilder.setBeneficiaryInternalTransactionIdentifier(mnbQrCodeRaw.getBeneficiaryInternalTransactionIdentifier());
        mnbQrCodeBuilder.setBeneficiaryOrRegularCustomerIdentifier(mnbQrCodeRaw.getBeneficiaryOrRegularCustomerIdentifier());
        mnbQrCodeBuilder.setVerificationNumberOfNAV(mnbQrCodeRaw.getVerificationNumberOfNAV());

        return mnbQrCodeBuilder.createMnbQrCode();
    }

    private Integer mapAmountOfMoney(MnbQrCodeRaw mnbQrCodeRaw) {
        return Optional.ofNullable(mnbQrCodeRaw.getAmountOfMoney())
                .map(Integer::parseInt)
                .orElse(null);
    }

    private IdentificationCode mapIdentificationCode(MnbQrCodeRaw mnbQrCodeRaw) {
        return Optional.ofNullable(mnbQrCodeRaw.getIdentificationCode())
                .map(IdentificationCode::valueOf)
                .orElse(null);
    }
}
