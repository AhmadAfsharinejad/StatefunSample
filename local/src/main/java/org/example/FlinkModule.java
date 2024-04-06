package org.example;

import com.google.auto.service.AutoService;
import org.apache.flink.statefun.sdk.spi.StatefulFunctionModule;

import java.util.Map;

//Note: don't use StatefulFunctionModule for operation
@AutoService(StatefulFunctionModule.class)
public class FlinkModule implements StatefulFunctionModule {
    @Override
    public void configure(Map<String, String> map, Binder binder) {
        binder.bindIngressRouter(FlinkConstants.MESSAGE_INGRESS, new FlinkRouter());
        binder.bindFunctionProvider(FlinkConstants.FILTER_FUNCTION_TYPE, unused -> new FilterFunction());
        binder.bindFunctionProvider(FlinkConstants.COUNT_FUNCTION_TYPE, unused -> new CountFunction());
    }
}
