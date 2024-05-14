package org.example;

import org.apache.flink.statefun.flink.io.datastream.SourceFunctionSpec;
import org.apache.flink.statefun.sdk.FunctionType;
import org.apache.flink.statefun.sdk.IngressType;
import org.apache.flink.statefun.sdk.io.IngressIdentifier;
import org.apache.flink.statefun.sdk.io.IngressSpec;
import org.example.generated.People;
import org.example.generated.People2;
import org.example.io.EmbeddedSourceFunction;
import org.example.io.EmbeddedSourceFunction2;

public final class Constants {

    public static long Node =0;
    public static final String NAMESPACE = "embeddedNamespace";

    public static final String EMBEDDED_TYPE_NAME = "embeddedDto";
    public static final IngressType INGRESS_TYPE = new IngressType(NAMESPACE, "embeddedIngressType");
    public static final IngressIdentifier<People> INGRESS_IDENTIFIER = new IngressIdentifier<>(People.class, NAMESPACE, "embeddedIngressIdentifierName");
    public static final IngressSpec<People> INGRESSSPEC = new SourceFunctionSpec<>(INGRESS_IDENTIFIER, new EmbeddedSourceFunction());

    public static final IngressIdentifier<People2> INGRESS_IDENTIFIER_2 = new IngressIdentifier<>(People2.class, NAMESPACE, "embeddedIngressIdentifierName2");
    public static final IngressSpec<People2> INGRESSSPEC2 = new SourceFunctionSpec<>(INGRESS_IDENTIFIER_2, new EmbeddedSourceFunction2());


    public static final IngressIdentifier<People> INGRESS_IDENTIFIER1_2 = new IngressIdentifier<>(People.class, NAMESPACE, "embeddedIngressIdentifierName1_2");
    public static final IngressSpec<People> INGRESSSPEC1_2 = new SourceFunctionSpec<>(INGRESS_IDENTIFIER1_2, new EmbeddedSourceFunction());

    public static final IngressIdentifier<People> INGRESS_IDENTIFIER1_3 = new IngressIdentifier<>(People.class, NAMESPACE, "embeddedIngressIdentifierName1_3");
    public static final IngressSpec<People> INGRESSSPEC1_3 = new SourceFunctionSpec<>(INGRESS_IDENTIFIER1_3, new EmbeddedSourceFunction());

    public static final IngressIdentifier<People> INGRESS_IDENTIFIER1_4 = new IngressIdentifier<>(People.class, NAMESPACE, "embeddedIngressIdentifierName1_4");
    public static final IngressSpec<People> INGRESSSPEC1_4 = new SourceFunctionSpec<>(INGRESS_IDENTIFIER1_4, new EmbeddedSourceFunction());


    public static final FunctionType DUMMY_FUNCTION_TYPE = new FunctionType(NAMESPACE, "dummy-function");
}
