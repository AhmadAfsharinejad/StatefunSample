package org.example.metaData;

import org.apache.flink.statefun.sdk.java.TypeName;
import org.apache.flink.statefun.sdk.java.types.SimpleType;
import org.apache.flink.statefun.sdk.java.types.Type;
import org.example.Constants;
import org.example.entities.Person;

import static org.example.CustomSerializer.messageMapper;

public final class PersonMetaData {

    public static final Type<Person> PERSON_TYPE =
            SimpleType.simpleImmutableTypeFrom(
                    TypeName.typeNameOf(Constants.TYPES_NAMESPACE, "GetPerson"),
                    messageMapper::writeValueAsBytes,
                    bytes -> messageMapper.readValue(bytes, Person.class));
    //Note: Content-Type: application/vnd.stateFunSampleNS/GetPerson
    // curl --location --request PUT 'localhost:8090/stateFunSampleNS/Dummy/123' --header 'Content-Type: application/vnd.stateFunSampleNS/GetPerson' --data '{ "id": "1", "name": "ahmad" }'
    //Note: 123 is function id
}
