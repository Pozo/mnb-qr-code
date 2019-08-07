package com.github.pozo.mnb.qrcode;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.domain.MnbQrCodeBuilder;
import com.github.pozo.mnb.qrcode.domain.MnbQrCodeBuilderHCTWithDefaultValues;
import io.nayuki.qrcodegen.QrCode;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

public class MnbQrCodeServiceTest {

    private MnbQrCodeService underTest = new MnbQrCodeService();

    @Test
    public void serialize() {
        // GIVEN
        MnbQrCodeBuilder mnbQrCodeBuilder = new MnbQrCodeBuilderHCTWithDefaultValues(
                "HUBUDOTP12",
                "Zoltan",
                "IBAN",
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
                "IBAN",
                "20190801121133+1"
        );
        mnbQrCodeBuilder.setAmountOfMoney(1200);
        MnbQrCode qrCode = mnbQrCodeBuilder.createMnbQrCode();

        // WHEN
        String qrCodeContent = underTest.serialize(qrCode);
        underTest.deserialize(qrCodeContent);

        // THEN
    }

    @Test
    public void print() throws IOException {
        // GIVEN
        MnbQrCodeBuilder mnbQrCodeBuilder = new MnbQrCodeBuilderHCTWithDefaultValues(
                "HUBUDOTP12",
                "Zoltan",
                "IBAN",
                "20190801121133+1"
        );
        mnbQrCodeBuilder.setAmountOfMoney(1200);
        mnbQrCodeBuilder.setBeneficiaryInternalTransactionIdentifier("ID123456789");
        mnbQrCodeBuilder.setMerchantDeviceIdentifier("POS123456789");
        mnbQrCodeBuilder.setStatement("Enjoy your stay");
        mnbQrCodeBuilder.setInvoiceOrReceiptIdentifier("1130/46130/25/40");

        MnbQrCode qr = mnbQrCodeBuilder.createMnbQrCode();
        String qrCodeContent = underTest.serialize(qr);
        // WHEN

        // THEN
        QrCode qrCode = QrCode.encodeText(qrCodeContent, QrCode.Ecc.MEDIUM);
        BufferedImage qrCodeImage = qrCode.toImage(10, 10);
        ImageIO.write(qrCodeImage, "png", new File("qr-code.png"));

    }
}