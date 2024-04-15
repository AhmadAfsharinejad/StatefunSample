package org.example;

import io.undertow.Undertow;
import org.apache.flink.statefun.sdk.java.StatefulFunctions;
import org.apache.flink.statefun.sdk.java.handler.RequestReplyHandler;
import org.example.functions.DummyFunction;
import org.example.functions.FilterFunction;

import static io.undertow.UndertowOptions.ENABLE_HTTP2;

public class Main {
    public static void main(String... args) {
        StatefulFunctions functions = new StatefulFunctions();
        functions.withStatefulFunction(DummyFunction.SPEC);
        functions.withStatefulFunction(FilterFunction.SPEC);
        RequestReplyHandler handler = functions.requestReplyHandler();

        /* This example uses the Undertow http server, but any HTTP server/framework will work as-well */
        Undertow server =
                Undertow.builder()
                        .addHttpListener(1108, "0.0.0.0")
                        .setHandler(new UndertowStateFunHandler(handler))
                        .setServerOption(ENABLE_HTTP2, true)
                        .build();

        server.start();
    }
}
