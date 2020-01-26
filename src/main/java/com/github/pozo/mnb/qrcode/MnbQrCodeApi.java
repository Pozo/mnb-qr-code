package com.github.pozo.mnb.qrcode;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;

import java.util.List;

public interface MnbQrCodeApi {

    /**
     * Takes a {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} as parameter and try to serialize it to a String.
     * It won't validate the input semantically, you must use {@link MnbQrCodeApi#validate(com.github.pozo.mnb.qrcode.domain.MnbQrCode)} or {@link MnbQrCodeApi#validateAnRetrieveErrors(com.github.pozo.mnb.qrcode.domain.MnbQrCode)}.
     *
     * @param mnbQrCode An {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} instance
     * @return A String representation of a {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode}. Check out the specification for details.
     */
    String serialize(MnbQrCode mnbQrCode);

    /**
     * Takes a String as parameter and try to deserialize it to a {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} instance.
     * It won't validate the input semantically, you must take care of it yourself.
     *
     * @param mnbQrCode A String representation of a {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode}. Check out the specification for details.
     * @return An {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} instance
     */
    MnbQrCode deserialize(String mnbQrCode);

    /**
     * Validates an {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} instance. It will check the followings:
     * <ul>
     *   <li>The presence of a given field if it's mandatory</li>
     *   <li>The length of a given field</li>
     * </ul>
     * It won't validate the content of a field, you must take care of it yourself.
     * It won't change the state of the given {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} instance.
     *
     * @param mnbQrCode An {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} instance
     * @return true if there is no error found during the validation.
     */
    boolean validate(MnbQrCode mnbQrCode);

    /**
     * Validates an {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} and retrieve the occurred errors during the validation.
     * It will check the followings:
     * <ul>
     *   <li>The presence of a given field if it's mandatory</li>
     *   <li>The length of a given field</li>
     * </ul>
     * It won't validate the content of a field, you must take care of it yourself.
     * It won't affect the state of the {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} instance.
     *
     * @param mnbQrCode An {@link com.github.pozo.mnb.qrcode.domain.MnbQrCode} instance
     * @return A list of occurred errors during the validation.
     */
    List<String> validateAnRetrieveErrors(MnbQrCode mnbQrCode);
}
