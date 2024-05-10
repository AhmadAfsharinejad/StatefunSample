package org.example.functions;

import org.apache.flink.statefun.sdk.Context;
import org.apache.flink.statefun.sdk.FunctionType;
import org.apache.flink.statefun.sdk.StatefulFunction;
import org.example.Constants;

public class DummyOutputFunction implements StatefulFunction {
    public static final FunctionType TYPE = new FunctionType(Constants.NAMESPACE, "dummy-function");
    private static int counter = 0;

    @Override
    public void invoke(Context context, Object object) {

        System.out.println("Dummy" + counter);
        counter++;
    }
}
