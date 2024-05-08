package org.example;

import com.google.auto.service.AutoService;
import org.apache.flink.statefun.sdk.spi.StatefulFunctionModule;
import org.example.functions.DummyOutputFunction;

import java.util.Map;

@AutoService(StatefulFunctionModule.class)
public class EmbeddedModule implements StatefulFunctionModule {
    @Override
    public void configure(Map<String, String> map, Binder binder) {
        binder.bindIngress(Constants.INGRESSSPEC);
        binder.bindIngressRouter(Constants.INGRESS_MESSAGE, new EmbeddedRouter());
        binder.bindFunctionProvider(DummyOutputFunction.TYPE, ignored -> new DummyOutputFunction());
    }
}
