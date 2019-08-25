# mnb-qr-code

##### cat README.md > /dev/hu
A Magyar Nemzeti Bank, a GIRO Zrt. és az azonnali fizetési projekt kiegészítő szolgáltatási munkacsoportja [által kidolgozott](https://www.mnb.hu/penzforgalom/azonnalifizetes/utmutatok) QR-kódos adatbeviteli mód Java implementációja a [publikált útmutató](https://www.mnb.hu/letoltes/qr-kod-utmutato-20190712.pdf) alapján.

Az implementáció nem teljes.

##### cat README.md > /dev/en
Hungarian instant payment QR code generator/parser library written in Java and based on the official [instant payment guide from MNB](https://www.mnb.hu/letoltes/qr-kod-utmutato-20190712.pdf).

Currently the implementation is not complete, it's under development. 

### Build 
  
    ./gradlew clean build
    
### Example

    MnbQrCodeService mnbQrCodeService = new MnbQrCodeService();
    MnbQrCodeBuilder mnbQrCodeBuilder = new MnbQrCodeBuilderHCTWithDefaultValues(
            "HUBUDOTP12",
            "Zoltan",
            "",
            "20190801121133+1"
    );
    mnbQrCodeBuilder.setAmountOfMoney(1200);
    MnbQrCode qrCode = mnbQrCodeBuilder.createMnbQrCode();
    String qrCodeContent = mnbQrCodeService.serialize(qrCode);

You can find more in the test folder.

**Mind the license.**
