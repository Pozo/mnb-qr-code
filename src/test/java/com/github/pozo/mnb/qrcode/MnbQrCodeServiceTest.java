package com.github.pozo.mnb.qrcode;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.domain.MnbQrCodeBuilder;
import com.github.pozo.mnb.qrcode.domain.MnbQrCodeBuilderHCTWithDefaultValues;
import io.nayuki.qrcodegen.QrCode;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MnbQrCodeServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private MnbQrCodeApi underTest = new MnbQrCodeService();

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
    public void validate() {
        // GIVEN
        MnbQrCodeBuilder mnbQrCodeBuilder = new MnbQrCodeBuilderHCTWithDefaultValues(
                "HUB012345678910",
                "Zoltan",
                "IBAN",
                "20190801121133+1"
        );
        MnbQrCode qrCode = mnbQrCodeBuilder.createMnbQrCode();

        // WHEN
        boolean isValid = underTest.validate(qrCode);

        // THEN
        assertFalse(isValid);
    }

    @Test
    public void validateAndRetrieveErrors() {
        // GIVEN
        MnbQrCodeBuilder mnbQrCodeBuilder = new MnbQrCodeBuilderHCTWithDefaultValues(
                "HUB012345678910",
                "Zoltan",
                "IBAN",
                "20190801121133+1"
        );
        MnbQrCode qrCode = mnbQrCodeBuilder.createMnbQrCode();

        // WHEN
        List<String> errors = underTest.validateAnRetrieveErrors(qrCode);

        // THEN
        assertFalse(errors.isEmpty());
        assertEquals(1, errors.size());

        final String firstErrorMessage = errors.get(0);
        assertEquals("Field 'PAYER_OR_BENEFICIARY_BIC' can't be longer than '11'. The actual size is '15'", firstErrorMessage);
    }

    @Test
    public void serializeAndDeserialize() {
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
        MnbQrCode deserialized = underTest.deserialize(qrCodeContent);

        // THEN
        assertEquals(qrCode, deserialized);
    }

    @Test
    public void deserialize_WhenQrCode_IsEmpty() throws IOException {
        // GIVEN
        String QR_CODE_000 = loadTestFile("INVALID-QR-CODE-3");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The 'mnbQrCode' parameter can't be empty!");

        // WHEN
        underTest.deserialize(QR_CODE_000);
        // THEN
    }

    @Test
    public void deserialize_WhenIdentificationCode_IsEmpty() throws IOException {
        // GIVEN
        String QR_CODE_000 = loadTestFile("INVALID-QR-CODE-0");

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("The 'identificationCode' parameter can't be null!");

        // WHEN
        underTest.deserialize(QR_CODE_000);
        // THEN
    }

    @Test
    public void deserialize_WhenIdentificationCode_FormatIsWrong() throws IOException {
        // GIVEN
        String QR_CODE_002 = loadTestFile("INVALID-QR-CODE-2");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No enum constant com.github.pozo.mnb.qrcode.domain.IdentificationCode.XXX");

        // WHEN
        underTest.deserialize(QR_CODE_002);
        // THEN
    }

    @Test
    public void deserialize_WhenVersionNumber_IsEmpty() throws IOException {
        // GIVEN
        String QR_CODE_001 = loadTestFile("INVALID-QR-CODE-1");

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("The 'versionNumber' parameter can't be null!");

        // WHEN
        underTest.deserialize(QR_CODE_001);
        // THEN
    }

    private String loadTestFile(String testFileName) throws IOException {
        final ClassLoader classLoader = MnbQrCodeServiceTest.class.getClassLoader();
        final URL resource = classLoader.getResource(testFileName);
        final File file = new File(resource.getFile());

        return new String(Files.readAllBytes(file.toPath()));
    }

    @Test
    public void serializeAndDeserializeWithAllFields() {
        // GIVEN
        MnbQrCodeBuilder mnbQrCodeBuilder = new MnbQrCodeBuilderHCTWithDefaultValues(
                "HUBUDOTP12",
                "Zoltan",
                "IBAN",
                "20190801121133+1"
        );
        mnbQrCodeBuilder.setAmountOfMoney(1200);
        mnbQrCodeBuilder.setVerificationNumberOfNAV("NAV-98765432");
        mnbQrCodeBuilder.setBeneficiaryOrRegularCustomerIdentifier("ID98765");
        mnbQrCodeBuilder.setBeneficiaryInternalTransactionIdentifier("ID-98765-XX");
        mnbQrCodeBuilder.setCustomerIdentifier("CT-99");
        mnbQrCodeBuilder.setInvoiceOrReceiptIdentifier("1130/46130/25/40");
        mnbQrCodeBuilder.setMerchantDeviceIdentifier("POS123456789");
        mnbQrCodeBuilder.setCommercialUnitIdentifier("CU-98765-HU");
        mnbQrCodeBuilder.setPaymentSituationIdentifier("PS-U-C-7654321");
        mnbQrCodeBuilder.setStatement("Yolo");
        MnbQrCode qrCode = mnbQrCodeBuilder.createMnbQrCode();

        // WHEN
        String qrCodeContent = underTest.serialize(qrCode);

        MnbQrCode deserialized = underTest.deserialize(qrCodeContent);

        // THEN
        assertEquals(qrCode, deserialized);
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