package org.example;

import org.apache.flink.statefun.sdk.IngressType;
import org.apache.flink.statefun.sdk.io.IngressIdentifier;
import org.apache.flink.statefun.sdk.io.IngressSpec;

import java.util.Objects;

public final class EmbeddedIngressSpec<T> implements IngressSpec<T> {
    private final IngressIdentifier<T> id;

    public EmbeddedIngressSpec(IngressIdentifier<T> id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public IngressType type() {
        return Constants.INGRESS_TYPE;
    }

    @Override
    public IngressIdentifier<T> id() {
        return id;
    }
}
