package org.example.functions;

import org.apache.flink.statefun.sdk.java.Context;
import org.apache.flink.statefun.sdk.java.StatefulFunction;
import org.apache.flink.statefun.sdk.java.StatefulFunctionSpec;
import org.apache.flink.statefun.sdk.java.TypeName;
import org.apache.flink.statefun.sdk.java.message.Message;
import org.example.Constants;
import org.example.entities.Person;
import org.example.messages.PersonMessage;
import org.example.messages.RowMessage;

import java.util.concurrent.CompletableFuture;

public final class FilterFunction  implements StatefulFunction {

    public static final TypeName TYPE = TypeName.typeNameFromString(Constants.TYPES_NAMESPACE + "/Filter");
    public static final StatefulFunctionSpec SPEC = StatefulFunctionSpec.builder(TYPE)
            .withSupplier(FilterFunction::new)
            .build();

    @Override
    public CompletableFuture<Void> apply(Context context, Message message) throws Throwable {

        System.out.println("filter");

        if (message.is(PersonMessage.PERSON_TYPE)) {
            Person person = message.as(PersonMessage.PERSON_TYPE);
            System.out.println(person.getName());
        }

        if(message.is(RowMessage.ROW_TYPE)){
            var row = message.as(RowMessage.ROW_TYPE);
        }

        return context.done();
    }
}
