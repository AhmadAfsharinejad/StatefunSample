package org.example.functions;

import org.apache.flink.statefun.sdk.Context;
import org.apache.flink.statefun.sdk.StatefulFunction;
import org.apache.flink.statefun.sdk.annotations.Persisted;
import org.apache.flink.statefun.sdk.state.PersistedValue;
import org.example.Common.TimeProvider;

public class DummyOutputFunction implements StatefulFunction {

    @Persisted
    private final PersistedValue<String> SEEN = PersistedValue.of("seen", String.class);

    @Override
    public void invoke(Context context, Object object) {

        String counter = context.self().id().trim().trim();

        SEEN.set(counter);

        if(counter.equals("10")){
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

//        if(counter % 10000 == 0)
        {
            System.out.println("26counter: " + counter + "  Id: " + context.self().id() +
                    "  currentTime:" + TimeProvider.getCurrentTime() +
                    " ThreadId: " + Thread.currentThread().getId());
        }

//        counter++;
    }
}
