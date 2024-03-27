package org.example;

import org.apache.flink.statefun.sdk.Context;
import org.apache.flink.statefun.sdk.StatefulFunction;
import org.example.generated.People;

//Note: there is org.apache.flink.statefun.sdk.java.Context also but not compatible with StatefulFunctionModule
public class FilterFunction implements StatefulFunction {
    @Override
    public void invoke(Context context, Object object) {
        if (!(object instanceof People)) {
            throw new RuntimeException("bad message.");
        }

        var people = (People) object;
        if (people.getAge() < 50) {
            return;
        }

        context.send(FlinkConstants.COUNT_FUNCTION_TYPE, Integer.toString(people.getAge()), people);
    }
}
