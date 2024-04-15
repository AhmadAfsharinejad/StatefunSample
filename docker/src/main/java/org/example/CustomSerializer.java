package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public final class CustomSerializer {
    public static final ObjectMapper messageMapper;

    static {
        messageMapper = new ObjectMapper();
        messageMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
