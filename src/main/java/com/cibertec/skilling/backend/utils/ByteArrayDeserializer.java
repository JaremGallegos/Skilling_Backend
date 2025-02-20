package com.cibertec.skilling.backend.utils;

import java.io.IOException;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ByteArrayDeserializer extends JsonDeserializer<byte[]> {
    @Override
    public byte[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String base64String = p.getText();
        if (base64String.contains(",")) {
            base64String = base64String.substring(base64String.indexOf(",") + 1);
        }
        return Base64.getDecoder().decode(base64String);
    }
}
