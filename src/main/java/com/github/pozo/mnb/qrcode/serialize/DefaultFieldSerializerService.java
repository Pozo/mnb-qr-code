package com.github.pozo.mnb.qrcode.serialize;

import com.github.pozo.mnb.qrcode.domain.MnbQrCode;
import com.github.pozo.mnb.qrcode.serialize.fields.AmountOfMoneySerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.BeneficiaryInternalTransactionIdentifierSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.BeneficiaryOrRegularCustomerSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.CharacterSetSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.CommercialUnitSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.CustomerIdentifierSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.IdentificationSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.InvoiceOrReceiptSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.MerchantDeviceIdentifierSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.PayerOrBeneficiaryBICSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.PayerOrBeneficiaryIBANSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.PayerOrBeneficiaryNameSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.PaymentSituationSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.StatementSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.ValiditySerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.VerificationNumberOfNAVSerializer;
import com.github.pozo.mnb.qrcode.serialize.fields.VersionNumberSerializer;
import com.github.pozo.mnb.qrcode.spec.QrCodeFields;

import java.util.EnumMap;

public class DefaultFieldSerializerService implements FieldSerializerService {

    private final EnumMap<QrCodeFields, FieldSerializer> serializers = new EnumMap<>(QrCodeFields.class);

    public DefaultFieldSerializerService() {
        setSerializer(QrCodeFields.IDENTIFICATION_CODE, new IdentificationSerializer());
        setSerializer(QrCodeFields.VERSION_NUMBER, new VersionNumberSerializer());
        setSerializer(QrCodeFields.CHARACTER_SET, new CharacterSetSerializer());
        setSerializer(QrCodeFields.PAYER_OR_BENEFICIARY_BIC, new PayerOrBeneficiaryBICSerializer());
        setSerializer(QrCodeFields.PAYER_OR_BENEFICIARY_NAME, new PayerOrBeneficiaryNameSerializer());
        setSerializer(QrCodeFields.PAYER_OR_BENEFICIARY_IBAN, new PayerOrBeneficiaryIBANSerializer());
        setSerializer(QrCodeFields.AMOUNT_OF_MONEY, new AmountOfMoneySerializer());
        setSerializer(QrCodeFields.VALIDITY, new ValiditySerializer());
        setSerializer(QrCodeFields.PAYMENT_SITUATION_IDENTIFIER, new PaymentSituationSerializer());
        setSerializer(QrCodeFields.STATEMENT, new StatementSerializer());
        setSerializer(QrCodeFields.COMMERCIAL_UNIT_IDENTIFIER, new CommercialUnitSerializer());
        setSerializer(QrCodeFields.MERCHANT_DEVICE_IDENTIFIER, new MerchantDeviceIdentifierSerializer());
        setSerializer(QrCodeFields.INVOICE_OR_RECEIPT_IDENTIFIER, new InvoiceOrReceiptSerializer());
        setSerializer(QrCodeFields.CUSTOMER_IDENTIFIER, new CustomerIdentifierSerializer());
        setSerializer(QrCodeFields.BENEFICIARY_INTERNAL_TRANSACTION_IDENTIFIER, new BeneficiaryInternalTransactionIdentifierSerializer());
        setSerializer(QrCodeFields.BENEFICIARY_OR_REGULAR_CUSTOMER_IDENTIFIER, new BeneficiaryOrRegularCustomerSerializer());
        setSerializer(QrCodeFields.VERIFICATION_NUMBER_OF_NAV, new VerificationNumberOfNAVSerializer());
    }

    @Override
    public void setSerializer(QrCodeFields field, FieldSerializer fieldSerializer) {
        serializers.put(field, fieldSerializer);
    }

    @Override
    public String serialize(MnbQrCode mnbQrCode, QrCodeFields field) {
        if (!serializers.containsKey(field)) {
            throw new IllegalArgumentException(String.format("There is no serializer found for '%s'", field));
        } else {
            return serializers.get(field).serialize(mnbQrCode);
        }
    }
}
