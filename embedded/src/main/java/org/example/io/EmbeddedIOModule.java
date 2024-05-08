package org.example.io;

import com.google.auto.service.AutoService;
import org.apache.flink.statefun.flink.io.kafka.KafkaSourceProvider;
import org.apache.flink.statefun.flink.io.spi.FlinkIoModule;
import org.example.Constants;

import java.util.Map;

@AutoService(FlinkIoModule.class)
public final class EmbeddedIOModule implements FlinkIoModule {
    @Override
    public void configure(Map<String, String> map, Binder binder) {
        binder.bindSourceProvider(Constants.INGRESS_TYPE, new EmbeddedSourceProvider());
    }
}
