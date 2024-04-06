package org.example;

import static io.undertow.UndertowOptions.ENABLE_HTTP2;

import io.undertow.Undertow;
import org.apache.flink.statefun.sdk.java.StatefulFunctionSpec;
import org.apache.flink.statefun.sdk.java.StatefulFunctions;
import org.apache.flink.statefun.sdk.java.handler.RequestReplyHandler;

public class Main {
    public static void main(String... args) {
//        StatefulFunctionSpec stockFn =
//                StatefulFunctionSpec.builder(StockFn.TYPE)
//                        .withValueSpec(StockFn.STOCK)
//                        .withSupplier(StockFn::new)
//                        .build();
//
//        StatefulFunctionSpec userShoppingCartFn =
//                StatefulFunctionSpec.builder(UserShoppingCartFn.TYPE)
//                        .withValueSpec(UserShoppingCartFn.BASKET)
//                        .withSupplier(UserShoppingCartFn::new)
//                        .build();
//
//        StatefulFunctions functions = new StatefulFunctions();
//        functions.withStatefulFunction(stockFn).withStatefulFunction(userShoppingCartFn);
//        RequestReplyHandler handler = functions.requestReplyHandler();
//
//        /* This example uses the Undertow http server, but any HTTP server/framework will work as-well */
//        Undertow server =
//                Undertow.builder()
//                        .addHttpListener(1108, "0.0.0.0")
//                        .setHandler(new UndertowStateFunHandler(handler))
//                        .setServerOption(ENABLE_HTTP2, true)
//                        .build();
//
//        server.start();
    }
}
