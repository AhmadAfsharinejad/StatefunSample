package org.example.messages;

import org.apache.flink.statefun.sdk.java.TypeName;
import org.apache.flink.statefun.sdk.java.types.SimpleType;
import org.apache.flink.statefun.sdk.java.types.Type;
import org.example.Constants;
import org.example.entities.Row;

import static org.example.CustomSerializer.messageMapper;

public class RowMessage {
    public static final Type<Row> ROW_TYPE =
            SimpleType.simpleImmutableTypeFrom(
                    TypeName.typeNameOf(Constants.TYPES_NAMESPACE, "GetRow"),
                    messageMapper::writeValueAsBytes,
                    bytes -> messageMapper.readValue(bytes, Row.class));
}
