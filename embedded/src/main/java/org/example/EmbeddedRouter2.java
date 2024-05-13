package org.example;

import org.apache.flink.statefun.sdk.io.Router;
import org.example.functions.DummyOutputFunction2;
import org.example.generated.People2;

public class EmbeddedRouter2 implements Router<People2> {
    @Override
    public void route(People2 input, Downstream<People2> downstream) {
        downstream.forward(DummyOutputFunction2.TYPE, input.getId(), input);
    }
}
