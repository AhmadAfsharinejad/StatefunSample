package org.example.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.statefun.sdk.reqreply.generated.TypedValue;
import org.apache.flink.statefun.sdk.shaded.com.google.protobuf.ByteString;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.example.Constants;
import org.example.EmbeddedSerializer;
import org.example.dtos.EmbeddedDto;

public class EmbeddedSourceFunction extends RichSourceFunction<TypedValue> {
    private volatile boolean running = true;

    @Override
    public void run(SourceContext<TypedValue> sourceContext) throws Exception {
        int counter = 0;

        System.out.println("HI. i am starting produce some data");

        while (running) {

            if(counter == 100){
                return;
            }

            Thread.sleep(1000);

            synchronized (sourceContext.getCheckpointLock()) {
                //TODO
                sourceContext.collect(getTypedValue(new EmbeddedDto(Integer.toString(counter),"salam")));
                counter++;
            }
        }
    }

    public static TypedValue getTypedValue(EmbeddedDto embeddedDto) throws JsonProcessingException {
        return TypedValue.newBuilder()
                .setTypename(Constants.EMBEDDED_TYPE_NAME)
                .setHasValue(true)
                .setValue(ByteString.copyFrom(EmbeddedSerializer.messageMapper.writeValueAsBytes(embeddedDto)))
                .build();
    }

    @Override
    public void cancel() {
        running = false;
    }
}
