package org.example;


import org.apache.flink.statefun.sdk.io.Router;
import org.example.generated.People;

public class FlinkRouter implements Router<People> {
    @Override
    public void route(People people, Downstream<People> downstream) {
        downstream.forward(FlinkConstants.FILTER_FUNCTION_TYPE, people.getId(), people);
    }
}
