# mnb-qr-code
Implemented with the help of the [instant payment guide from MNB](https://www.mnb.hu/letoltes/qr-kod-utmutato-20190712.pdf).

Currently the implementation is not complete, it's under development. 

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
