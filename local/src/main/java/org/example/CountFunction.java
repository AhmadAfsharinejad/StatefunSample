package org.example;

import org.apache.flink.statefun.sdk.Context;
import org.apache.flink.statefun.sdk.StatefulFunction;
import org.apache.flink.statefun.sdk.annotations.Persisted;
import org.apache.flink.statefun.sdk.state.PersistedValue;
import org.example.generated.People;

public class CountFunction implements StatefulFunction {

    @Persisted
    private final PersistedValue<Integer> SEEN = PersistedValue.of("seen", Integer.class);

    @Override
    public void invoke(Context context, Object object) {
        if (!(object instanceof People)) {
            throw new RuntimeException("bad message.");
        }

        var seenCount = SEEN.getOrDefault(0) + 1;
        SEEN.set(seenCount);

        if (seenCount < 10) {
            return;
        }

        var people = (People) object;

        context.send(FlinkConstants.MESSAGE_EGRESS, people);
    }
}
