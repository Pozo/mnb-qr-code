package com.github.pozo.mnb.qrcode.serialize;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.spec.QrCodeFields;

public interface FieldSerializerService {

    void setSerializer(
            QrCodeFields field,
            FieldSerializer fieldSerializer
    );

    String serialize(MnbQrCode mnbQrCode, QrCodeFields qrCode);
}
