package org.example.io;

import org.apache.flink.statefun.flink.io.spi.SourceProvider;
import org.apache.flink.statefun.sdk.io.IngressSpec;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.example.EmbeddedIngressSpec;

public class EmbeddedSourceProvider implements SourceProvider {
    @Override
    public <T> SourceFunction<T> forSpec(IngressSpec<T> spec) {
        final EmbeddedIngressSpec ingressSpec = asEmbeddedIngressSpec(spec);

        throw new RuntimeException("not implemented!");
    }

    private static <T> EmbeddedIngressSpec asEmbeddedIngressSpec(IngressSpec<T> spec) {
        if (spec instanceof EmbeddedIngressSpec) {
            return (EmbeddedIngressSpec) spec;
        }

        throw new IllegalArgumentException(String.format("Unknown ingress spec %s", spec));
    }
}
