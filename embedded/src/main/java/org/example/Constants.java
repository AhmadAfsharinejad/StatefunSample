package org.example;

import org.apache.flink.statefun.flink.io.datastream.SourceFunctionSpec;
import org.apache.flink.statefun.sdk.IngressType;
import org.apache.flink.statefun.sdk.io.IngressIdentifier;
import org.apache.flink.statefun.sdk.io.IngressSpec;
import org.example.dtos.EmbeddedDto;
import org.example.io.EmbeddedSourceFunction;

public final class Constants {
    public static final String NAMESPACE = "embeddedNamespace";
    public static final IngressType INGRESS_TYPE = new IngressType(NAMESPACE, "embedded-ingress");
    public static final IngressIdentifier<EmbeddedDto> INGRESS_MESSAGE = new IngressIdentifier<>(EmbeddedDto.class, NAMESPACE, "embeddedDto");
    public static final IngressSpec<EmbeddedDto> INGRESSSPEC = new SourceFunctionSpec<>(INGRESS_MESSAGE, new EmbeddedSourceFunction());
}
