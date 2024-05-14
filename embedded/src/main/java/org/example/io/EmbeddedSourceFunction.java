package org.example.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.statefun.sdk.reqreply.generated.TypedValue;
import org.apache.flink.statefun.sdk.shaded.com.google.protobuf.ByteString;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.example.Common.TimeProvider;
import org.example.Constants;
import org.example.EmbeddedSerializer;
import org.example.dtos.EmbeddedDto;
import org.example.generated.People;

public class EmbeddedSourceFunction extends RichSourceFunction<People> {
    private volatile boolean running = true;
//    private final long MaxFinal = 1_000_000_000;
    private final long MaxFinal = 1_00;

    @Override
    public void run(SourceContext<People> sourceContext) throws Exception {
        long counter = 0;

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("startTime: " + TimeProvider.getCurrentTime());

        while (running) {

//            Thread.sleep(10);

//            synchronized (sourceContext.getCheckpointLock())
            {
                //TODO
//                sourceContext.collect(getTypedValue(new EmbeddedDto(Integer.toString(counter),"salam")));
                sourceContext.collect(getItem(counter));
                System.out.println("myCounter: ============" + counter);
                counter++;
            }

            if(counter == MaxFinal){

                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("endTime: " + TimeProvider.getCurrentTime());

                return;
            }
        }
    }

    private People getItem(long id){
        return People.newBuilder().setId(String.valueOf(id)).setAge(1).setName("123").build();
    }

    //TODO notworking! error NoSuchMethodError in statefun
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
