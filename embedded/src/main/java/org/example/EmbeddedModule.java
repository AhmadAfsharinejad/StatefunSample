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
        binder.bindIngressRouter(Constants.INGRESS_IDENTIFIER, new EmbeddedRouter());

//        binder.bindIngress(Constants.INGRESSSPEC1_2);
//        binder.bindIngressRouter(Constants.INGRESS_IDENTIFIER1_2, new EmbeddedRouter());
//
//        binder.bindIngress(Constants.INGRESSSPEC1_3);
//        binder.bindIngressRouter(Constants.INGRESS_IDENTIFIER1_3, new EmbeddedRouter());
//
//        binder.bindIngress(Constants.INGRESSSPEC1_4);
//        binder.bindIngressRouter(Constants.INGRESS_IDENTIFIER1_4, new EmbeddedRouter());
//
//
//        binder.bindIngress(Constants.INGRESSSPEC2);
//        binder.bindIngressRouter(Constants.INGRESS_IDENTIFIER_2, new EmbeddedRouter2());

        binder.bindFunctionProvider(Constants.DUMMY_FUNCTION_TYPE, ignored -> new DummyOutputFunction());
        binder.bindFunctionProvider(DummyOutputFunction2.TYPE, ignored -> new DummyOutputFunction2());
    }
}
