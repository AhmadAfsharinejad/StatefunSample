package org.example;

import org.apache.flink.statefun.sdk.io.Router;
import org.apache.flink.statefun.sdk.reqreply.generated.TypedValue;
import org.example.dtos.EmbeddedDto;
import org.example.functions.DummyOutputFunction;

public class EmbeddedRouter implements Router<TypedValue> {
    @Override
    public void route(TypedValue embeddedDto, Downstream<TypedValue> downstream) {
        downstream.forward(DummyOutputFunction.TYPE, "1", embeddedDto);
    }
}
