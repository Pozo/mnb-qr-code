package com.github.pozo.mnb.qrcode;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.domain.MnbQrCodeBuilder;
import com.github.pozo.mnb.qrcode.domain.MnbQrCodeBuilderHCTWithDefaultValues;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class MnbQrCodeServiceTest {

    private MnbQrCodeService underTest = new MnbQrCodeService();

    @Test
    public void serialize() {
        // GIVEN
        MnbQrCodeBuilder mnbQrCodeBuilder = new MnbQrCodeBuilderHCTWithDefaultValues(
                "HUBUDOTP12",
                "Zoltan",
                "",
                "20190801121133+1"
        );
        MnbQrCode qrCode = mnbQrCodeBuilder.createMnbQrCode();

        // WHEN
        String qrCodeContent = underTest.serialize(qrCode);

        // THEN
        assertTrue(qrCodeContent.contains("HUBUDOTP12\n"));
        assertTrue(qrCodeContent.contains("Zoltan\n"));
        assertTrue(qrCodeContent.contains("20190801121133+1\n"));
    }

    @Test
    public void deserialize() {
        // GIVEN
        MnbQrCodeBuilder mnbQrCodeBuilder = new MnbQrCodeBuilderHCTWithDefaultValues(
                "HUBUDOTP12",
                "Zoltan",
                "",
                "20190801121133+1"
        );
        mnbQrCodeBuilder.setAmountOfMoney(1200);
        MnbQrCode qrCode = mnbQrCodeBuilder.createMnbQrCode();

        // WHEN
        String qrCodeContent = underTest.serialize(qrCode);
        underTest.deserialize(qrCodeContent);

        // THEN

    }
}