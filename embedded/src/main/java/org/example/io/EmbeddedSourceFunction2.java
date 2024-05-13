package org.example.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.statefun.sdk.reqreply.generated.TypedValue;
import org.apache.flink.statefun.sdk.shaded.com.google.protobuf.ByteString;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.example.Common.TimeProvider;
import org.example.Constants;
import org.example.EmbeddedSerializer;
import org.example.dtos.EmbeddedDto;
import org.example.generated.People2;

public class EmbeddedSourceFunction2 extends RichSourceFunction<People2> {
    private volatile boolean running = true;

    @Override
    public void run(SourceContext<People2> sourceContext) throws Exception {
        int counter = 0;

        System.out.println("22$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$22");
        System.out.println("startTime2: " + TimeProvider.getCurrentTime());

        while (running) {

//            Thread.sleep(1000);

            synchronized (sourceContext.getCheckpointLock()) {
                //TODO
//                sourceContext.collect(getTypedValue(new EmbeddedDto(Integer.toString(counter),"salam")));
                sourceContext.collect(getItem(counter));
                counter++;
            }

            if(counter == 1_000_000){

                System.out.println("22$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$22");
                System.out.println("endTime2: " + TimeProvider.getCurrentTime());

                return;
            }
        }
    }

    private static People2 getItem(int id){
        return People2.newBuilder().setId(String.valueOf(id)).setAge(1).setName("123").build();
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
