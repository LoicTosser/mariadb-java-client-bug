package com.test.mariabd;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.nio.ByteBuffer;
import java.util.UUID;

@ReadingConverter
public class StringToUuidonverter implements Converter<byte[], UUID> {

    @Override
    public UUID convert(byte[] source) {
        if (source.length != 16) {
            throw new IllegalArgumentException(
                    "Cannot convert byte[] of length " + source.length + " to UUID");
        }
        ByteBuffer bb = ByteBuffer.wrap(source);
        long high = bb.getLong();
        long low = bb.getLong();
        return new UUID(high, low);
    }
}
