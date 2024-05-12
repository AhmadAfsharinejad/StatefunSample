package org.example;

import org.apache.flink.statefun.flink.io.datastream.SourceFunctionSpec;
import org.apache.flink.statefun.sdk.IngressType;
import org.apache.flink.statefun.sdk.io.IngressIdentifier;
import org.apache.flink.statefun.sdk.io.IngressSpec;
import org.apache.flink.statefun.sdk.reqreply.generated.TypedValue;
import org.example.dtos.EmbeddedDto;
import org.example.generated.People;
import org.example.io.EmbeddedSourceFunction;

public final class Constants {
    public static final String NAMESPACE = "embeddedNamespace";
    public static final String EMBEDDED_TYPE_NAME = "embeddedDto";
    public static final IngressType INGRESS_TYPE = new IngressType(NAMESPACE, "embeddedIngressType");
    public static final IngressIdentifier<People> INGRESS_MESSAGE = new IngressIdentifier<>(People.class, NAMESPACE, "embeddedIngressIdentifierName");
    public static final IngressSpec<People> INGRESSSPEC = new SourceFunctionSpec<>(INGRESS_MESSAGE, new EmbeddedSourceFunction());
}
