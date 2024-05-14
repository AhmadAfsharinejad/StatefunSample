package org.example.functions;

import org.apache.flink.statefun.sdk.java.Context;
import org.apache.flink.statefun.sdk.java.StatefulFunction;
import org.apache.flink.statefun.sdk.java.StatefulFunctionSpec;
import org.apache.flink.statefun.sdk.java.TypeName;
import org.apache.flink.statefun.sdk.java.message.Message;
import org.apache.flink.statefun.sdk.java.message.MessageBuilder;
import org.example.Constants;
import org.example.entities.Person;
import org.example.entities.Row;
import org.example.metaData.PersonMetaData;
import org.example.metaData.RowMetaData;

import java.util.concurrent.CompletableFuture;

public final class DummyFunction implements StatefulFunction {

    public static final TypeName TYPE = TypeName.typeNameFromString(Constants.TYPES_NAMESPACE + "/Dummy");
    public static final StatefulFunctionSpec SPEC = StatefulFunctionSpec.builder(TYPE)
//            .withValueSpec(CART_STATE)
            .withSupplier(DummyFunction::new)
            .build();

    @Override
    public CompletableFuture<Void> apply(Context context, Message message) throws Throwable {

        System.out.println("dummy");

        if (message.is(PersonMetaData.PERSON_TYPE)) {
            Person person = message.as(PersonMetaData.PERSON_TYPE);
            System.out.println(person.getName());

            Person newPerson = new Person(444, "23");

            Object[] res = new Object[3];
            res[0] = 21;
            res[1] = "sds";
            res[2] = false;
            Row row = new Row(res);

            Message newMessage =
                    MessageBuilder.forAddress(FilterFunction.TYPE, String.valueOf(newPerson.getId()))
                            .withCustomType(RowMetaData.ROW_TYPE, row)
                            .build();

            context.send(newMessage);
        }

        return context.done();
    }
}
