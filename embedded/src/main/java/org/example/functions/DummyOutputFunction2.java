package org.example.functions;

import org.apache.flink.statefun.sdk.Context;
import org.apache.flink.statefun.sdk.FunctionType;
import org.apache.flink.statefun.sdk.StatefulFunction;
import org.example.Common.TimeProvider;
import org.example.Constants;

public class DummyOutputFunction2 implements StatefulFunction {
    public static final FunctionType TYPE = new FunctionType(Constants.NAMESPACE, "dummy-function-2");
    private int counter = 0;
    private long firstTime = 0;

    @Override
    public void invoke(Context context, Object object) {
        if(firstTime == 0){
            firstTime =  System.currentTimeMillis();
            System.out.println("22^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^22");
        }

        if(counter % 10000 == 0){
            System.out.println("counter: " + counter + "  Id: " + context.self().id() + " node:" + firstTime + "  currentTime:" + TimeProvider.getCurrentTime());
        }

        counter++;
    }
}
