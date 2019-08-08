package com.github.pozo.mnb.qrcode.serialize;

import java.util.function.Supplier;

interface FieldSerializeService<FROM, TO> {

    FROM deserialize(Supplier<TO> function);

    TO serialize(Supplier<FROM> function);

}
