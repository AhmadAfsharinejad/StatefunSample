package org.example;

import org.apache.flink.statefun.sdk.FunctionType;
import org.apache.flink.statefun.sdk.io.EgressIdentifier;
import org.apache.flink.statefun.sdk.io.IngressIdentifier;
import org.example.generated.People;

public final class FlinkConstants {
    private static final String NAMESPACE = "statefun-harness";
    public static final IngressIdentifier<People> MESSAGE_INGRESS = new IngressIdentifier<>(People.class, NAMESPACE, "ingress");
    public static final EgressIdentifier<People> MESSAGE_EGRESS = new EgressIdentifier<>(NAMESPACE, "egress", People.class);
    static final FunctionType FILTER_FUNCTION_TYPE = new FunctionType(NAMESPACE, "filter-function");
    static final FunctionType COUNT_FUNCTION_TYPE = new FunctionType(NAMESPACE, "count-function");
}
