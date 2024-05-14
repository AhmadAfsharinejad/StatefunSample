package org.example;

import org.apache.flink.statefun.sdk.io.Router;
import org.example.generated.People;
import org.example.functions.DummyOutputFunction;

public class EmbeddedRouter implements Router<People> {
    @Override
    public void route(People input, Downstream<People> downstream) {
        downstream.forward(Constants.DUMMY_FUNCTION_TYPE, input.getId(), input);
    }
}

