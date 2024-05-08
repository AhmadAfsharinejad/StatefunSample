package org.example.io;

import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.example.dtos.EmbeddedDto;

public class EmbeddedSourceFunction extends RichSourceFunction<EmbeddedDto> {
    private volatile boolean running = true;

    @Override
    public void run(SourceContext<EmbeddedDto> sourceContext) throws Exception {
        int counter = 0;
        while (running) {
            Thread.sleep(1000);

            synchronized (sourceContext.getCheckpointLock()) {
                //TODO
                sourceContext.collect(new EmbeddedDto(Integer.toString(counter),"salam"));
                counter++;
            }
        }
    }

    @Override
    public void cancel() {
        running = false;
    }
}
