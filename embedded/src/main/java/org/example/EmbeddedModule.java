package org.example;

import com.google.auto.service.AutoService;
import org.apache.flink.statefun.sdk.spi.StatefulFunctionModule;
import org.example.functions.DummyOutputFunction;
import org.example.functions.DummyOutputFunction2;

import java.util.Map;

@AutoService(StatefulFunctionModule.class)
public class EmbeddedModule implements StatefulFunctionModule {
    @Override
    public void configure(Map<String, String> map, Binder binder) {
        binder.bindIngress(Constants.INGRESSSPEC);
        binder.bindIngressRouter(Constants.INGRESS_MESSAGE, new EmbeddedRouter());

        binder.bindIngress(Constants.INGRESSSPEC2);
        binder.bindIngressRouter(Constants.INGRESS_MESSAGE2, new EmbeddedRouter2());

        binder.bindFunctionProvider(DummyOutputFunction.TYPE, ignored -> new DummyOutputFunction());
        binder.bindFunctionProvider(DummyOutputFunction2.TYPE, ignored -> new DummyOutputFunction2());
    }
}
