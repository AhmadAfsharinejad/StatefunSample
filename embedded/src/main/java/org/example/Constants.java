package org.example;

import org.apache.flink.statefun.flink.io.datastream.SourceFunctionSpec;
import org.apache.flink.statefun.sdk.IngressType;
import org.apache.flink.statefun.sdk.io.IngressIdentifier;
import org.apache.flink.statefun.sdk.io.IngressSpec;
import org.example.generated.People;
import org.example.generated.People2;
import org.example.io.EmbeddedSourceFunction;
import org.example.io.EmbeddedSourceFunction2;

public final class Constants {
    public static final String NAMESPACE = "embeddedNamespace";
    public static final String EMBEDDED_TYPE_NAME = "embeddedDto";
    public static final IngressType INGRESS_TYPE = new IngressType(NAMESPACE, "embeddedIngressType");
    public static final IngressIdentifier<People> INGRESS_MESSAGE = new IngressIdentifier<>(People.class, NAMESPACE, "embeddedIngressIdentifierName");
    public static final IngressIdentifier<People2> INGRESS_MESSAGE2 = new IngressIdentifier<>(People2.class, NAMESPACE, "embeddedIngressIdentifierName2");
    public static final IngressSpec<People> INGRESSSPEC = new SourceFunctionSpec<>(INGRESS_MESSAGE, new EmbeddedSourceFunction());
    public static final IngressSpec<People2> INGRESSSPEC2 = new SourceFunctionSpec<>(INGRESS_MESSAGE2, new EmbeddedSourceFunction2());
}
