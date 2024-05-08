package org.example;

import org.apache.flink.statefun.sdk.io.Router;
import org.example.dtos.EmbeddedDto;
import org.example.functions.DummyOutputFunction;

public class EmbeddedRouter implements Router<EmbeddedDto> {
    @Override
    public void route(EmbeddedDto embeddedDto, Downstream<EmbeddedDto> downstream) {
        downstream.forward(DummyOutputFunction.TYPE, "1", embeddedDto);
    }
}
